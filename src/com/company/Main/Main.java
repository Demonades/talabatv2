package com.company.Main;

import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //Scanner input = new Scanner(System.in);
        WelcomeMenu.welcome();

        /*/
        while (false) {

                    } else if (test == null) {
                        System.out.println("WRONG EMAIL OR PASSWORD , TRY AGAIN");
                        System.out.println("_____________________");
                    }


                } else if (i == 2) {

                    RestaurantOwner test = RestaurantOwner.login(e_mail, trypassword);
                    if (test != null) {
                        while (true) {
                            System.out.println("1 - add meal");
                            System.out.println("2 - delete meal ");
                            System.out.println("3 - log out ");

                            //modify????
                            System.out.println("choose : ");
                            i = input.nextInt();
                            if (i == 1) {

                                String meal_name;
                                float meal_price;
                                String meal_description;
                                System.out.println("enter meal name : ");
                                meal_name = input.next();
                                System.out.println("enter meal price : ");
                                meal_price = input.nextFloat();
                                System.out.println("enter meal description : ");
                                meal_description = input.next();
                                Meal NewMeal = new Meal(meal_name, meal_price, meal_description);
                                NewMeal.insertIntoDB(test.getRestaurant());

                            } else if (i == 2) {
                                Meal.dispalayMealList(test.getRestaurant());
                                System.out.println("choose : ");
                                ArrayList<Meal> RestaurantMeals = new ArrayList<Meal>(100);
                                RestaurantMeals = Meal.getMealList(test.getRestaurant());
                                i = input.nextInt();
                                RestaurantMeals.get(i - 1).deleteMeal();
                                System.out.println("deleted");
                                System.out.println("_______________");
                            } else if (i == 3) {
                                break;
                            }

                        }
                    } else if (test == null) {
                        System.out.println("WRONG EMAIL OR PASSWORD , TRY AGAIN");
                    }


                }

            }
            // break
            else if (i == 3) {
                break;
            }
        }
        /*/

    }
}