package com.zerodha.kite;

import com.zerodhatech.kiteconnect.KiteConnect;
import com.zerodhatech.kiteconnect.kitehttp.SessionExpiryHook;
import com.zerodhatech.kiteconnect.kitehttp.exceptions.KiteException;
import com.zerodhatech.models.User;

public class KiteAPIUtility {
    public static void main(String[] args) {
        try{
            KiteConnect kiteConnect = new KiteConnect("");

            //Set user id
            kiteConnect.setUserId("");

            String url = kiteConnect.getLoginURL();

            //Set Session Expiry callback
            kiteConnect.setSessionExpiryHook(
                    new SessionExpiryHook() {
                        @Override
                        public void sessionExpired() {
                            System.out.println("Session Expired");
                        }
                    }
            );

            /* The request token can to be obtained after completion of login process.
               Check out https://kite.trade/docs/connect/v3/user/#login-flow for more information.
               A request token is valid for only a couple of minutes and can be used only once.
               An access token is valid for one whole day. Don't call this method for every app run.
               Once an access token is received it should be stored in preferences or database for further usage.
            */
            User user =  kiteConnect.generateSession("xxxxxtttyyy", "xxxxxxxyyyyy");
            kiteConnect.setAccessToken(user.accessToken);
            kiteConnect.setPublicToken(user.publicToken);

            KiteCoreMethods kiteCoreMethods = new KiteCoreMethods();

            //Get Kite Profile Details
            kiteCoreMethods.getProfile(kiteConnect);

            //Get Margins
            kiteCoreMethods.getMargins(kiteConnect);

        }catch (Exception | KiteException e){
            e.printStackTrace();
        }
    }
}
