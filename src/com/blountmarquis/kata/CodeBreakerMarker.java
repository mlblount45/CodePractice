package com.blountmarquis.kata;

/**
 * Created by mlblount on 1/19/2016..
 *
 */
public class CodeBreakerMarker {

    public static String getMarker(String secret, String guess) {

        if (secret.isEmpty() || guess.isEmpty()) return "";
        return buildMarker(secret, guess);
    }

    private static String buildMarker(String secret, String guess) {
        StringBuilder sbMatch = new StringBuilder();
        StringBuilder sbContain = new StringBuilder();

        for(int i = 0; i < secret.length(); i++){
            if(isGuessIndexMatchSecret(secret,guess,i)) sbMatch.append("b");
            else{
                if(isGuessContainedInSecret(secret,guess,i)) sbContain.append("w");
            }
        }

        return sbMatch.append(sbContain).toString();
    }

    private static boolean isGuessContainedInSecret(String secret, String guess,int index) {return secret.indexOf(guess.charAt(index)) > -1;}

    private static boolean isGuessIndexMatchSecret(String secret, String guess, int index) {return secret.charAt(index) == guess.charAt(index);}
}
