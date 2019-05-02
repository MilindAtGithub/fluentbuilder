package com.milind.fluentbuilder;

/**
 * This is the pojo class which will contain all info needed to send plain text email
 * This is sample code to demonstrate the Fluent builder pattern
 * @author  Milind D
 */
public final class Email {

    // To Address. Multiple Address separated by ","
    String to;
    //From Address
    String from;
    // Subject of the email
    String subject;
    // Content of the email
    String content;
    // BCC optional
    String bcc;
    // CC Optional
    String cc;

    /**
     * Private constructor to prevent the object initialization
     */
    private Email(String to, String from, String subject, String content, String bcc, String cc) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.content = content;
        this.bcc = bcc;
        this.cc = cc;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public String getBcc() {
        return bcc;
    }

    public String getCc() {
        return cc;
    }

    @Override
    public String toString() {
        return "Email{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", bcc='" + bcc + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }

    // Interface to Set From
    interface EmailFrom {
        EmailTo setFrom(String from);
    }
    //Interface to Set To
    interface  EmailTo {
        EmailSubject setTo(String to);
    }
    //Interface to Set subject
    interface  EmailSubject {
        EmailContent setSubject(String subject);
    }
    // Interface to set Content
    interface  EmailContent {
        EmailCreator setContent(String content);
    }
    // Final Email Creator Class
    interface EmailCreator {

        EmailCreator setBCC(String bcc);
        EmailCreator setCC(String cc);
        Email build();
    }

    /** Static class for building the email object
     */
    public static class EmailBuilder implements  EmailFrom, EmailTo, EmailSubject, EmailContent, EmailCreator{

        String to;
        String from;
        String subject;
        String content;
        String bcc;
        String cc;

        /**
         * Private emailbuilder to prevent direct object creation
         */
        private EmailBuilder(){
        }

        /**
         * Getting the instance method
         * @return
         */
        public static EmailFrom getInstance(){
            return  new EmailBuilder();
        }

        @Override
        public EmailTo setFrom(String from) {
            this.from = from;
            return this;
        }

        @Override
        public EmailSubject setTo(String to) {
            this.to = to;
            return this;
        }

        @Override
        public EmailContent setSubject(String subject) {
            this.subject=subject;
            return this;
        }

        @Override
        public EmailCreator setContent(String content) {
            this.content=content;
            return this;
        }

        @Override
        public EmailBuilder setBCC(String bcc) {
            this.bcc=bcc;
            return this;
        }

        @Override
        public EmailBuilder setCC(String cc) {
            this.cc =cc;
            return this;
        }

        @Override
        public Email build() {
            return new Email(to,from,subject,content,bcc, cc);
        }
    }
}
