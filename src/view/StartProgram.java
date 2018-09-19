package view;

import java.util.List;
import java.util.Scanner;

import controller.CarDAO;
import controller.CarQuery;
import model.Car;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static CarDAO carDAO = new CarDAO();

		private static void addAnItem() {
			System.out.print("Enter a make: ");
			String make = in.nextLine();
			System.out.print("Enter an model: ");
			String model= in.nextLine();
			System.out.print("Enter a year: ");
			int year = in.nextInt();
			Car toAdd = new Car(make, model, year);
			carDAO.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			System.out.print("Enter the make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the year to delete: ");
			int year = in.nextInt();
			List<Car> foundCars;
			CarQuery carq = new CarQuery();
			foundCars = carq.searchByMakeModelAndYear(make, model, year);
			Car toDelete = foundCars.get(0);
			int idToDelete = toDelete.getId();
			carDAO.removeItem(idToDelete);
		}

		private static void editAnItem() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Model");
			System.out.println("3 : Search by Year");
			String selection = in.nextLine();
			while (!(selection.equals("1") || selection.equals("2") || selection.equals("3"))) {
				System.out.println("Please make a valid selection between 1 and 3");
				selection = in.nextLine();
			}
			int searchBy = Integer.parseInt(selection);
			List<Car> foundCars;
			CarQuery carq = new CarQuery();
			if (searchBy == 1) {
				System.out.print("Enter the make: ");
				String makeName = in.nextLine();
				foundCars = carq.searchByMake(makeName);
			} else if (searchBy == 2) {
				System.out.print("Enter the model: ");
				String modelName = in.nextLine();
				foundCars = carq.searchByModel(modelName);
			} else {
				System.out.print("Enter the year: ");
				int yearIn = in.nextInt();
				foundCars = carq.searchByYear(yearIn);
			}

			if (!foundCars.isEmpty()) {
				System.out.println("Found Results.");
				for (Car c : foundCars) {
					System.out.println(c.getId() + " : " + c.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Car toEdit = carDAO.searchForCarById(idToEdit);
				System.out.println("Retrieved " + toEdit.getYear() + " " + toEdit.getMake() + " " + toEdit.getModel());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Year");
				String selectedUpdate = in.nextLine();
				while (!(selectedUpdate.equals("1") || selectedUpdate.equals("2") || selectedUpdate.equals("3"))) {
					System.out.println("Please make a valid selection between 1 and 3");
					selectedUpdate = in.nextLine();
				}
				int update = Integer.parseInt(selectedUpdate);

				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
					carDAO.updateMake(idToEdit, newMake);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
					carDAO.updateModel(idToEdit, newModel);
				} else {
					System.out.print("New Year: ");
					int newYear = in.nextInt();
					toEdit.setYear(newYear);
					carDAO.updateYear(idToEdit, newYear);
				}
//				lih.updateItem(toEdit);
//				lih.updateItem(toEdit, newItem);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome car list! ---");
			while (goAgain) {
				System.out.println("*  Select a menu item:");
				System.out.println("*  1 -- Add a car");
				System.out.println("*  2 -- Edit a car");
				System.out.println("*  3 -- Delete a car");
				System.out.println("*  4 -- View the list of cars");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				String selectionString = in.nextLine();
				while (!(selectionString.equals("1") || selectionString.equals("2") || selectionString.equals("3") || selectionString.equals("4") || selectionString.equals("5"))) {
					System.out.println("Please make a valid selection between 1 and 5");
					selectionString = in.nextLine();
				}
					
				int selection = Integer.parseInt(selectionString);

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					carDAO.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			CarQuery carq = new CarQuery();
			List<Car> results = carq.retrieveAll();
			for (Car c : results) {
				System.out.println(c.getYear() + " " + c.getMake() + " " + c.getModel());
			}
			

		}

	}