import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Inventory {
	HashMap cars;
	
	public Inventory(String fname) throws FileNotFoundException{
		cars = readCars(fname);
		}

		public void updateInventoryFile(String fn){
		// Overwrite inventory.txt with Car array
		}
		
	public static HashMap readCars(String fname) throws FileNotFoundException { 
		HashMap list = new HashMap();
		// System.out.println(fname);
		File file = new File(fname);
		Scanner f1 = new Scanner(file);
		while(f1.hasNext()) { 
			Car newCar = new Car();
			StringTokenizer str = new StringTokenizer(f1.nextLine(), "/");
			String VIN = str.nextToken();
			newCar.setVin(VIN);
			newCar.setBrand(str.nextToken());
			newCar.setModel(str.nextToken());
			newCar.setYear(Integer.parseInt(str.nextToken()));
			newCar.setMileage(Integer.parseInt(str.nextToken()));
			newCar.setPrice(Double.parseDouble(str.nextToken()));
			newCar.setColor((str.nextToken()).charAt(0));
			// newCar.print();
			list.put(VIN, newCar);
		}
		f1.close();
		return list;
	}
	
	public void updateInventory(String fname) throws FileNotFoundException { 
		PrintWriter outputFile = new PrintWriter(fname);
		for (Object VIN: cars.keySet()) { 
			Car car = (Car) cars.get(VIN);
			outputFile.print(car.vin + "/" + car.brand + "/" + car.model + "/" + car.year + "/");
			outputFile.printf("%.2f", car.price);
			outputFile.println("/" + car.color);
		}
		outputFile.close();
		
	}
	public void printCategories() { 
		System.out.printf("%-13s%-12s%-10s%-10s%-10s%-10s%-10s\n", "VIN", "Brand", "Model", "Year", "Mileage", "Price", "Color");
	}
	public void printWithCat(Car car) { 
		printCategories();
		car.print();
		System.out.println();
	}
	public void displayAll() { 
		printCategories();
		for (Object VIN: cars.keySet()) { 
			Car car = (Car) cars.get(VIN);
			car.print();
		}
		System.out.println();
	
	}
	
	
	public void add() { 
		Scanner in = new Scanner(System.in);
		Car newCar = new Car();
		
		System.out.print("VIN: ");
		newCar.setVin(in.next());
		
		System.out.print("Brand: ");
		newCar.setBrand(in.next());
		
		System.out.print("Model: ");
		newCar.setModel(in.next());
		
		System.out.print("Year: ");
		newCar.setYear(in.nextInt());
		
		System.out.print("Mileage: ");
		newCar.setMileage(in.nextInt());
		
		System.out.print("Price: ");
		newCar.setPrice(in.nextFloat());
		
		System.out.print("Color: ");
		newCar.setColor(in.next().charAt(0));
		cars.put(newCar.vin, newCar);
		System.out.println();
		printWithCat(newCar);
		System.out.println("This car has been sucessfully added.\n");
		displayAll();
	}
	
	public void delete() { 
		Scanner in = new Scanner(System.in);
		displayAll();
		System.out.print("Please enter VIN: ");
		String VIN = in.next();
		System.out.println();
		if (cars.containsKey(VIN)) { 
			Car toDelete = (Car) cars.get(VIN);
			printWithCat(toDelete);
			cars.remove(VIN);
			System.out.println("This car has been sucessfully deleted.\n");
			displayAll();
		}
		else 
			System.out.println("Car does not exist.\n");
	}
	
	public void update() { 
		Scanner in = new Scanner(System.in);
		displayAll();
		System.out.print("Please enter VIN: ");
		String VIN = in.next();
		System.out.println();
		if (cars.containsKey(VIN)) { 
			Car car = (Car) cars.get(VIN);
			printWithCat(car);

			Menus.displayUpdateCar();
			
			System.out.print("Please select option: ");
			int choice = in.nextInt();
			
			if (choice == 1) {
				System.out.print("Please input brand: ");
				car.setBrand(in.next());
			}
			else if (choice == 2) {
				System.out.print("Please input model: ");
				car.setModel(in.next());
			}
			
			else if (choice == 3) {
				System.out.print("Please input year: ");

				car.setYear(in.nextInt());
			}
			
			else if (choice == 4) {
				System.out.print("Please input mileage: ");

				car.setMileage(in.nextInt());
			}			
			
			else if (choice == 5) {
				System.out.print("Please input price: ");

				car.setPrice(in.nextFloat());
			}
			
			else if (choice == 6) { 
				System.out.print("Please input color: ");
				car.setColor(in.next().charAt(0));
			}
			
			else {
				System.out.println("Option is not valid.\n" );
				return;
			}
			cars.put(car.vin, car);
			
			System.out.println("\nIt's been updated. Thank you. \n");
			printWithCat(car);
		}
		else 
			System.out.println("Car does not exist.\n");
	}
	
	public void sort() { 
		Menus.displaySort();
		Scanner in = new Scanner(System.in);
		System.out.print("Please input your choice: " );
		int sortChoice = in.nextInt();
		System.out.println();
		
		if (sortChoice == 1) { 
			
		}
		else if (sortChoice == 2) { 
					
				}
		else if (sortChoice == 3) { 
			
		}
		else if (sortChoice == 4) { 
			
		}
		else if (sortChoice == 5) { 
			
		}
		else if (sortChoice == 6) { 
			
		}
		
		else if (sortChoice == 7) { 
			
		}
		
		else { 
			System.out.println("Not a valid choice.\n");
		}
	}
}