package com.milind.fluentbuilder;

/**
 * Test Class
 */
public class EmailTest {


    public static void main(String args[]){

        //Creating basic email object without cc and bcc
        Email email =  Email.EmailBuilder.getInstance().setFrom("Test@gmail.com").setTo("mail@gmail.com")
                .setSubject("Test with only required Fields").setContent(" Required Field Test").build();

        System.out.println(email);

        //Creating the full Email Object with cc and bcc
        email =  Email.EmailBuilder.getInstance().setFrom("Test@gmail.com").setTo("mail@gmail.com")
                .setSubject("Test with ALL Fields").setContent(" ALL Field Test").setBCC("bcc@gmail.com")
                .setCC("cc@gmail.com").build();

        System.out.println(email);
    }
}
