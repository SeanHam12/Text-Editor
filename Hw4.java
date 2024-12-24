/*Author Sean Hamidi, 12/24/2024
 * The purpose of this program is to have a menu for the user to use a text editor 
 */

import java.util.Scanner;
public class Hw4 {
    public static void main(String[] args) {
        Scanner Keyboard = new Scanner(System.in);
        String paragraph = "";//empty paragraph
        String manipulated_paragraph = paragraph;//copied original
        int spec_word_count=0;
        boolean l = true;
        while(l){//to make my loops run
            //menu
            System.out.println(" ");
            System.out.print("Menu Options\n"); 
            makeBorder(50);
            System.out.println(
            "1.)Print Orginial and Manipulated Paragraph"
            +"\n2.)Print Details about the Manipulated Paragraph"
            +"\n3.)Search for a word and print out the quantity"
            +"\n4.)Replace a word with another word"
            +"\n5.)Print Detail about the three longest words:"
            +"\n6.)Enter a new paragraph to manipulate"
            +" \n7.) To Quit");//prompting user"
            System.out.println("Option:");
            int user_menu_choice = Keyboard.nextInt();//getting user input

        
        switch(user_menu_choice)//using user input as my switch variable
        {
            case 1://prints out orignial paragraph and manipulated paragraph
            System.out.println("Here is the original paragraph:\n" + paragraph);
            System.out.println("Here is the manipulated paragraph:\n" + manipulated_paragraph);
            break;
            case 2://prints out the word and vowel count
            int wordcount = 0;
            int vowelcount = 0;
            for (int i =0; i<manipulated_paragraph.length(); i++)
            {
                char word = manipulated_paragraph.charAt(i);//checks through every index to see if there is a value in there
                String vowellist = manipulated_paragraph.toLowerCase();
                char vowel = vowellist.charAt(i);        

                if (word == ' ')//if there is then the word count gets updated
                {
                    wordcount++;
                }   


                if((vowel == 'a') || (vowel == 'e') || (vowel == 'i') || (vowel == 'o') || (vowel == 'u'))
                {
                    vowelcount++;
                }
            }
            wordcount++;//to include the last word
            System.out.println("There are: " + wordcount + " words");
            System.out.println("Vowels are:" + vowelcount +" vowels");
            break;
            case 3:
                int next = 0;
                int start = 0;
                System.out.println("Please enter the word you would like to see how many times it appears:");
                String spec_user_word = Keyboard.next();
                String extract;
                int b =0;
                while(b==0)
                {
                    next=manipulated_paragraph.indexOf(" ", start);//to get the space after the word
                    if(start>next)//to include the last word
                    {
                        extract = manipulated_paragraph.substring((start));//takes the last index of a space and extracts it from there to the end of the paragraph
                        if(spec_user_word.equalsIgnoreCase(extract))//to make sure it matches specific word
                        {
                            spec_word_count++;
        
                        }
                        b = 1;//to end while loop
        
        
                    }
                    else 
                    {
                        extract = manipulated_paragraph.substring(start,next);//0,5 ,, 6,11
                        if(spec_user_word.equalsIgnoreCase(extract))//test
                        {
                            spec_word_count++;
                        }
                        start = next + 1;//even if it isnt true, start=6, 11+1 =12
                        
        
        
        
                    }
        
                }
                System.out.println("The word count for the word" + spec_user_word + " apperared " + spec_word_count + " times");

                break;


            case 4:
                int nexttt = 0;
                int starttt = 0;
                String extractt;
                int boy =0;
        
        
        
        
                System.out.println("Please enter the word you want to replace:");
                String wordreplace = Keyboard.next();
                System.out.println("What word do you want to replace it with");
                String replaceword=Keyboard.next();
                String temppara = "";//temporary paragraph
                while(boy==0)
                {
                    nexttt=manipulated_paragraph.indexOf(" ", starttt);//5, 11
                    if(starttt>nexttt)//same process as case 3
                    {
                        extract = manipulated_paragraph.substring((starttt));//this is for last word in text
                        if(wordreplace.equalsIgnoreCase(extract))//if any from the paragraph matches what the user wants to replace
                        {
                            temppara += replaceword + " " ;//we take their replace word and add it to the temporary paragraph
        
                        }
                        else
                        {
                            temppara += extract + " ";//if its not that word we add the other words in there
                        }
                        boy = 1;//end of loop variable 
        
        
                    }
                    else 
                    {
                        extract = manipulated_paragraph.substring(starttt,nexttt);//0,5 ,, 6,11
                        if(wordreplace.equalsIgnoreCase(extract))//test
                        {
                            temppara += replaceword + " ";//same thing as above but this is for words in the paragraph, any words thats not last
                        }
                        else
                        {
                            temppara += extract + " ";
                        }
                        starttt = nexttt + 1;//even if it isnt true, start=6, 11+1 =12
        
        
        
        
                    }
        
                }
                manipulated_paragraph=temppara;//temporary paragraph is then copied into the manipulated paragraph variable 
                break;

                case 5:
                // Print details about the three longest words and three shortest words
                if (manipulated_paragraph.trim().isEmpty()) {
                    System.out.println("Paragraph is empty. No words to analyze.");
                    break;
                }

                // Initialize three longest to "" and three shortest to something large
                String longest = "";
                String secondLongest = "";
                String thirdLongest = "";

                // Tildes as placeholders for "very large" so any real word is likely shorter
                String shortest = "~~~~~~~~~~~~";
                String secondShortest = "~~~~~~~~~~~~";
                String thirdShortest = "~~~~~~~~~~~~";

                // Parse the paragraph word by word
                int startIndex = 0;
                while (true) {
                    int spacePos = manipulated_paragraph.indexOf(" ", startIndex);
                    String currentWord;
                    
                    if (spacePos == -1) {
                        // No more spaces => last word
                        currentWord = manipulated_paragraph.substring(startIndex).trim();
                        if (!currentWord.isEmpty()) {
                            // Update longest & shortest
                            if (currentWord.length() > longest.length()) {
                                thirdLongest = secondLongest;
                                secondLongest = longest;
                                longest = currentWord;
                            } else if (currentWord.length() > secondLongest.length()) {
                                thirdLongest = secondLongest;
                                secondLongest = currentWord;
                            } else if (currentWord.length() > thirdLongest.length()) {
                                thirdLongest = currentWord;
                            }

                            if (currentWord.length() < shortest.length()) {
                                thirdShortest = secondShortest;
                                secondShortest = shortest;
                                shortest = currentWord;
                            } else if (currentWord.length() < secondShortest.length()) {
                                thirdShortest = secondShortest;
                                secondShortest = currentWord;
                            } else if (currentWord.length() < thirdShortest.length()) {
                                thirdShortest = currentWord;
                            }
                        }
                        break;
                    } else {
                        currentWord = manipulated_paragraph.substring(startIndex, spacePos).trim();
                        startIndex = spacePos + 1;
                        if (!currentWord.isEmpty()) {
                            // Update longest & shortest
                            if (currentWord.length() > longest.length()) {
                                thirdLongest = secondLongest;
                                secondLongest = longest;
                                longest = currentWord;
                            } else if (currentWord.length() > secondLongest.length()) {
                                thirdLongest = secondLongest;
                                secondLongest = currentWord;
                            } else if (currentWord.length() > thirdLongest.length()) {
                                thirdLongest = currentWord;
                            }

                            if (currentWord.length() < shortest.length()) {
                                thirdShortest = secondShortest;
                                secondShortest = shortest;
                                shortest = currentWord;
                            } else if (currentWord.length() < secondShortest.length()) {
                                thirdShortest = secondShortest;
                                secondShortest = currentWord;
                            } else if (currentWord.length() < thirdShortest.length()) {
                                thirdShortest = currentWord;
                            }
                        }
                    }
                }

                // If the paragraph has fewer than 3 words, some might remain "" or "~~~~~~~~~~~~"
                // For a basic assignment, we’ll just print them anyway.
                System.out.println("Three longest words:");
                System.out.println("1) " + longest);
                System.out.println("2) " + secondLongest);
                System.out.println("3) " + thirdLongest);

               /*  System.out.println("Three shortest words:");
                System.out.println("1) " + shortest);
                System.out.println("2) " + secondShortest);
                System.out.println("3) " + thirdShortest);

            */
                break;
                            
            case 6:
            System.out.print("Please enter your paragraph:");//ask user to print paragraph
            paragraph = Keyboard.nextLine();
            if (!paragraph.equals(" "))
            {
                paragraph = Keyboard.nextLine();

            }

            manipulated_paragraph = paragraph;//copies the value of the into temporary
            System.out.println("Paragraph recorded.");
            break;


            case 7:
                l=false;//ends loop
                break;

            }
       }
    }

    public static void makeBorder(int width)
    {
        String border = "";
        for(int i=0; i<width;i++)
        {
            border+="-";
        }
        System.out.println(border);

    }
}



















        







        


















    

