//Eliza With HashMap

package com.company;
import java.util.HashMap;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;


public class Easter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to a Therapy store, I am Eliza, How may I help you Today?");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Enter your Response here or 'Q' to End the chat");
        String s1 = sc.nextLine();

        while (!s1.equalsIgnoreCase("q")) {

            String res = getResponse(s1);
            if (s1.equals("play")) {
                playGame();
            } else if (s1.equals("caps")) {
                String allCaps = toUpperCase(res);
                System.out.println(allCaps);
            } else if (s1.equals("pig")) {
                String pigLatin = getLatinResponse(res);
                System.out.println(pigLatin);
            } else {
                System.out.println(res);
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Enter your Response here  or 'Q' to End the chat?");
            s1 = sc.nextLine();

        }
        System.out.println("Thank you for chatting with us today");
    }

    private static String getLatinResponse(String res) {
        String rMessage = "";
        //split only ino array
        String[] que = res.split(" ");

        //variable to change the string to pig lating
        String[] rejoin;
        rejoin = new String[que.length];
        //for loop to asign the que value to rejoin
        for (int i = 0; i < que.length; i++) {
            rejoin[i] = que[i].substring(1) + que[i].substring(0, 1) + "ay";
        }
        for (int i = 0; i < rejoin.length; i++) {
            rMessage += rejoin[i] + " ";
        }
        return rMessage;

    }


    private static void playGame() {
        Scanner sc = new Scanner(System.in);
        String answer;
        System.out.println("WELCOME TO MITCHELL'S TINY ADVENTURE!\n");
        System.out.println("You are in a creepy house!  Would you like to go 'upstairs' or into the 'kitchen'?");

        answer = sc.next();
        if (answer.toLowerCase().equals("kitchen")) {
            System.out.println("There is a long countertop with dirty dishes everywhere.  Off to one side there is, as you'd expect, a refrigerator. You may open the 'refrigerator' or look in a 'cabinet' Where would you like to go?");
            answer = sc.next();
            if (answer.toLowerCase().equals("refrigerator")) {
                System.out.println("Inside the refrigerator you see food and stuff.  It looks pretty nasty.\n" + "Would you like to eat some of the food? (\"yes\" or \"no\")");
                answer = sc.next();
                if (answer.toLowerCase().equals("yes")) {
                    System.out.println("Ok, Then Eat it");
                } else if (answer.toLowerCase().equals("no")) {
                    System.out.println("You die of starvation... eventually.");
                } else {
                    System.out.println("Your input is invalid");
                }

            } else if (answer.toLowerCase().equals("cabinet")) {
                System.out.println("There is Yougurt, would you like to eat, Yes/no?");
                answer = sc.next();
                if (answer.toLowerCase().equals("yes")) {
                    System.out.println("Ok, Then go ahead and eat it");
                } else if (answer.toLowerCase().equals("no")) {
                    System.out.println("You die of starvation... eventually.");
                } else {
                    System.out.println("Your input is invalid");
                }
            } else {
                System.out.println("invalid entry");
            }
        } else if (answer.toLowerCase().equals("upstairs")) {
            System.out.println("Upstairs you see a hallway. At the end of the hallway is the master 'bedroom'.  There is also a 'bathroom' off the hallway.  Where would you like to go?");
            answer = sc.next();
            if (answer.toLowerCase().equals("bedroom")) {
                System.out.println("You are in a plush bedroom, with expensive-looking hardwood furniture.  The\n" +
                        "bed is unmade.  In the back of the room, the closet door is ajar.  Would you\n" +
                        "like to open the door? (\"yes\" or \"no\")");
                answer = sc.next();
                if (answer.toLowerCase().equals("yes")) {
                    System.out.println("Ok, Then look at it");
                } else if (answer.toLowerCase().equals("no")) {
                    System.out.println("Well, then I guess you'll never know what was in there.  Thanks for playing,\n" +
                            "I'm tired of making nested if statements.");
                } else System.out.println("Your input is invalid");
            }
        }
    }

    private static String getResponse(String s1) {
        String message = "";
        String[] input = (s1.split(" "));
        for (int i = 0; i < input.length; i++) {
            String re = getReplace(input[i]);

            /*if (replacement.containsKey(userInput[i])) {
                //this code replaces the userinput to the value from the hash key
                userInput[i] = replacement.get(userInput[i]);*/


            if (input[i].contains("I")) {
                    input[i] = input[i].replace("I", re);
            } else if (input[i].contains("me")) {
                    input[i] = input[i].replace("me", re);
            } else if (input[i].contains("my")) {
                    input[i] = input[i].replace("my", re);
            } else if (input[i].contains("am")) {
                    input[i] = input[i].replace("am", re);
            } else if (input[i].contains("you")) {
                    input[i] = input[i].replace("you", re);
            } else if (input[i].contains("your")) {
                    input[i] = input[i].replace("your", re);
            } else {
                    input[i] = input[i];
            }
                message += (input[i] + " ");
        }
            //checking if the input contain these key words
            if ((s1.contains("I")) || (s1.contains("my")) || (s1.contains("me"))
                    || (s1.contains("am")) || (s1.contains("you"))) {
                //calling method to get a qualifier
                String qu = getQualif();
                message = (qu + " " + message);

            }
            else {
                //calling method to get a hedge
                String hed = getHedge();
                //Printing the hedge
                message = hed;

            }
                return message;
    }

            public static String getQualif () {
                Random rnd = new Random();
                HashMap<Integer, String> qualif = new HashMap<Integer, String>();
                qualif.put(1, "Why do you say that");
                qualif.put(2, "You seem to think that");
                qualif.put(3, "So you are concerned that");
                qualif.put(4, "So you are concerned that");

                int qual = rnd.nextInt(qualif.size());
                String quali = qualif.get(qual + 1);
                return quali;

            }

            public static String getHedge () {
                Random rnd = new Random();
                HashMap<Integer, String> hedge = new HashMap<>();
                hedge.put(1, "Please tell me more");
                hedge.put(2, "Many of my patients tell me the same thing It is getting late");
                hedge.put(3, "Maybe we better quit");
                hedge.put(4, "I think we should go now");

                int he = rnd.nextInt(hedge.size());
                String hed = hedge.get(he + 1);
                return hed;


            }

            private static String getReplace (String s){
                //METHOD creation and generating random value
                HashMap<String, String> replacements = new HashMap<>();
                replacements.put("I", "you");
                replacements.put("me", "your");
                replacements.put("am", "are");
                replacements.put("my", "your");
                replacements.put("you", "me");
                replacements.put("your", "my");

                String rp = replacements.get(s);

                return rp;
            }
        }
