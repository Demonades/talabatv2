package com.company.Main;

import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("_____________________");

            System.out.println("1 - sign up");
            System.out.println("2 - sign in ");
            System.out.println("3 - Exit ");
            System.out.println("_________________________");

            // i is user choice
            int i = input.nextInt();

            // sign up
            if (i == 1) {
                System.out.println("1 - customer");
                System.out.println("2 - owner ");
                System.out.println("_________________________");

                i = input.nextInt();
                // sign up as customer
                if (i == 1) {
                    String email, name, hash_password;
                    System.out.println("enter name : ");
                    name = input.next();
                    System.out.println("enter email : ");
                    email = input.next();
                    System.out.println("enter password : ");
                    hash_password = input.next();


                    Customer customer = new Customer(email, name, hash_password);
                    customer.insertIntoDB();
                    System.out.println("_________________________");


                }
                // sign up as owner
                else if (i == 2) {
                    String email, name, hash_password;
                    System.out.println("enter name : ");
                    name = input.next();
                    System.out.println("enter email : ");
                    email = input.next();
                    System.out.println("enter password : ");
                    hash_password = input.next();
                    System.out.println("_________________________");


                    RestaurantOwner owner = new RestaurantOwner(email, name, hash_password);
                    String phone, restaurant_name, location_name;
                    int location_id;
                    int category_id;
                    String category_name;
                    System.out.println("enter restaurant name  : ");
                    restaurant_name = input.next();
                    System.out.println("enter phone : ");
                    phone = input.next();
                    System.out.println("enter location : ");
                    location_name = input.next();
                    System.out.println("enter location id  : ");
                    location_id = input.nextInt();
                    Location location = new Location(location_id, location_name);

                    System.out.println("enter category : ");
                    category_name = input.next();
                    System.out.println("enter category id  : ");
                    category_id = input.nextInt();
                    System.out.println("_________________________");

                    Category category = new Category(category_id, category_name);

                    Register.RestaurantAndOwner(owner, restaurant_name, phone, location, category);


                }


            }
            // sign in
            else if (i == 2) {
                String e_mail, trypassword;
                System.out.println("enter your e-mail : ");
                e_mail = input.next();
                System.out.println("enter your password : ");
                trypassword = input.next();
                System.out.println("_________________________");

                System.out.println("1-user");
                System.out.println("2-owner");
                i = input.nextInt();
                System.out.println("_________________________");

                if (i == 1) {
                    Customer test = Customer.login(e_mail, trypassword);
                    if (test != null) {
                        while (true) {
                            System.out.println("1 - categories");
                            System.out.println("2 - all resturants ");
                            System.out.println("3 - search ");
                            System.out.println("4 - log out ");
                            System.out.println("_________________________");


                            System.out.println("choose : ");
                            i = input.nextInt();
                            //display all categories
                            if (i == 1) {

                                ArrayList<Restaurant> categorized_restaurants = new ArrayList<Restaurant>(100);
                                while (true) {
                                    Category.displayCategoryList();
                                    System.out.println("choose : ");
                                    i = input.nextInt();

                                    categorized_restaurants = Restaurant.getCategorizedRestaurants(i);

                                    if (categorized_restaurants.size() > 0) {
                                        Restaurant.displayRestaurants(categorized_restaurants);
                                        System.out.println("_________________________");
                                        System.out.println("choose : ");
                                        i = input.nextInt();
                                        if (i == 0) {
                                            break;
                                        }
                                        Meal.dispalayMealList(categorized_restaurants.get(i - 1));
                                        Meal.orderMeal(categorized_restaurants);
                                        break;

                                    }
                                }
                            }
                            //display all restaurants
                            else if (i == 2) {
                                while (true) {
                                    Restaurant.displayRestaurantListAll();
                                    i = input.nextInt();
                                    if (i == 0)
                                        break;
                                    ArrayList<Restaurant> all_restaurants = new ArrayList<Restaurant>(100);
                                    all_restaurants = Restaurant.getRestaurantListAll();
                                    Meal.dispalayMealList(all_restaurants.get(i - 1));
                                    Meal.orderMeal(all_restaurants);

                                }

                            }
                            //search
                            else if (i == 3) {
                                System.out.println("search by ");
                                System.out.println("1 - location ");
                                System.out.println("2 - restaurant name");
                                i = input.nextInt();
                                if (i == 1) {
                                    while (true) {
                                        ArrayList<Restaurant> restaurants_in_location = new ArrayList<Restaurant>(100);
                                        Location.displayLocationList();
                                        ArrayList<Location> locations = new ArrayList<Location>(100);
                                        locations = Location.getLocationList();
                                        i = input.nextInt();
                                        restaurants_in_location = Restaurant.getRestaurantsInLocation(locations.get(i - 1).getLocation_id());
                                        Restaurant.displayRestaurants(restaurants_in_location);
                                        i = input.nextInt();
                                        if (i == 0)
                                            break;
                                        Meal.dispalayMealList(restaurants_in_location.get(i - 1));
                                        Meal.orderMeal(restaurants_in_location);
                                    }
                                } else if (i == 2) {
                                    String restaurantname;
                                    ArrayList<Restaurant> restaurantsName = new ArrayList<Restaurant>(100);

                                    System.out.println("enter restaurant name : ");
                                    restaurantname = input.next();
                                    restaurantsName = Restaurant.getRestaurantListAll();
                                    for (int j = 0; j < restaurantsName.size(); j++) {
                                        if (restaurantsName.get(j).getRestaurant_name().equals(restaurantname)) {
                                            System.out.println("1 - " + restaurantsName.get(j).getRestaurant_name());
                                            i = input.nextInt();
                                            if (i == 1) {
                                                Meal.dispalayMealList(restaurantsName.get(j));
                                                Meal.orderMeal(restaurantsName);
                                            }
                                        }
                                    }

                                }


                            }
                            //log out
                            else if (i == 4) {
                                break;

                            }

                        }


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


    }
}