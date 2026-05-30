
package com.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.model.Booking;
import com.model.NRIResident;
import com.model.Payment;
import com.model.RIResident;
import com.model.Room;
import com.service.BookingService;
import com.service.ManagerService;
import com.service.NRIResidentService;
import com.service.PaymentService;
import com.service.RIResidentService;
import com.service.RoomService;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		RIResidentService RI=new RIResidentService();
		BookingService BS=new BookingService();
		RoomService RS=new RoomService();
		PaymentService PS=new PaymentService();
		NRIResidentService NRI = new NRIResidentService();
		ManagerService MS = new ManagerService();
		
		boolean flag=true;
		System.out.println("=================================================");
		System.out.println(">>>>>>>> Welcome To Sweet Homes Regency <<<<<<<<");
		System.out.println("=================================================");
		while(flag) {
			System.out.println("=================================");
			System.out.println("1. Customer Options");
			System.out.println("2. Manager Options");
			System.out.println("3. Exit");
			System.out.println("=================================");
			System.out.println("=================================");
			System.out.println("Enter your option");
			System.out.println("=================================");
			int option=sc.nextInt();
			
			if(option==1) {
				System.out.println("===== CUSTOMER MENU =====");
				System.out.println("1. RI Resident Details...");
				System.out.println("2. NRI Resident Details...");
				System.out.println("3. Booking Details...");
				System.out.println("4. Payment Details...");
				System.out.println("=============================");
				System.out.println("Enter your option");
				System.out.println("=============================");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					riloop:
					while(flag) {
						System.out.println("====== RI RESIDENT MENU ======");
						System.out.println("1. Add RI Resident");
						System.out.println("2. Update Phone Using Resident ID");
						System.out.println("3. Update Occupancy Using Resident ID");
						System.out.println("4. View RI Resident Details");
						System.out.println("5. Delete RI Resident");
						System.out.println("6. View All RI Residents");
						System.out.println("7. Exit");
						
						System.out.println("==============================");
						System.out.println("Enter the choice");
						System.out.println("==============================");
						int choice1=sc.nextInt();
						sc.nextLine();
						
						switch(choice1) {
						case 1:
							 System.out.println("Enter RI Resident details:");
			                 System.out.println("Format:");
			                 System.out.println("Name:Age:Gender:Contact:Email:Address:Adults:ChildrenAbove12:ChildrenAbove5:Duration:ResidentType:AadharNo");

			                 String input = sc.nextLine();
			                 
			                 boolean result=RI.addRIResidentList(input);
			                 
			                 if(result) {
			                	 System.out.println("RIResident added successfully!!!");
			                 }
			                 else {
			                	 System.out.println("No Resident added...");
			                 }
			                 break;
			                 
						case 2:
							 System.out.println("Enter Resident ID:");
			                 String ResidentId = sc.nextLine();

			                 System.out.println("Enter New Phone Number:");
			                 long newPhone = sc.nextLong();
			                 sc.nextLine();
			                 
			                 boolean result1=RI.updateRIResidentPhoneNumberUsingResidentId(ResidentId,newPhone);
			                 
			                 if(result1) {
			                	 System.out.println("Phone Number Added Successfully!!!");
			                 }
			                 else {
			                	 System.out.println("PhoneNumber not Updated...");
			                 }
			                 break;
			                 
			                 
						case 3:
							 System.out.println("Enter Resident ID:");
			                 String occupancyResidentId = sc.nextLine();

			                 System.out.println("Enter Number of Adults:");
			                 int adults = sc.nextInt();

			                 System.out.println("Enter Number of Children Above 12:");
			                 int above12 = sc.nextInt();

			                 System.out.println("Enter Number of Children Above 5:");
			                 int above5 = sc.nextInt();
			                 sc.nextLine();
			                 
			                 boolean result2=RI.updateOccupancyUsingResidentId(occupancyResidentId, adults, above12, above5);
			                 
			                 if(result2) {
			                	 System.out.println("Occupancy Updated Successfully");
			                 }
			                 else {
			                	 System.out.println("Occupancy not updated");
			                 }
			                 break;
			                 
			                 
						case 4:
							 System.out.println("Enter Resident ID:");
			                 String viewResidentId = sc.nextLine();

			                 
							 RIResident resident =RI.retreiveRIResidentDetails(viewResidentId);

			                 if (resident != null) {
			                     System.out.println("Resident ID: " + resident.getResidentId());
			                     System.out.println("Name: " + resident.getResidentName());
			                     System.out.println("Age: " + resident.getAge());
			                     System.out.println("Gender: " + resident.getGender());
			                     System.out.println("Contact: " + resident.getContactNumber());
			                     System.out.println("Email: " + resident.getEmail());
			                     System.out.println("Address: " + resident.getAddress());
			                     System.out.println("Adults: " + resident.getNumberOfAdults());
			                     System.out.println("Children Above 12: " + resident.getNumberOfChildrenAbove12());
			                     System.out.println("Children Above 5: " + resident.getNumberOfChildrenAbove5());
			                     System.out.println("Duration: " + resident.getDurationOfStay());
			                     System.out.println("Resident Type: " + resident.getResidentType());
			                     System.out.println("Aadhar No: " + resident.getIdproofAadharno());
			                 } else {
			                     System.out.println("Resident not found");
			                 }
			                 break;
			                 
						case 5:
							 System.out.println("Enter Resident ID:");
			                 String deleteResidentId = sc.nextLine();

			                 boolean Result3 =RI.deleteRIResidentDetailsFromDB(deleteResidentId);

			                 if (Result3) {
			                     System.out.println("Resident deleted successfully");
			                 } else {
			                     System.out.println("Resident not deleted");
			                 }
			                 break;
			                 
						
						case 6:

						    List<RIResident> residentList =RI.viewAllRIResidents();

						    if(residentList != null &&!residentList.isEmpty()) {

						        for(RIResident resident1 : residentList) {

						            System.out.println("---------------------------");

						            System.out.println("Resident ID: "+ resident1.getResidentId());

						            System.out.println("Resident Name: "+ resident1.getResidentName());

						            System.out.println("Phone Number: "+ resident1.getContactNumber());
						            
						            System.out.println("---------------------------");
						        }
						    }

						    else {

						        System.out.println(
						        "No Residents Found");
						    }

						    break;
			                 
						case 7:
						    
						    break riloop;
						    
			            default:
			            	System.out.println("Invalid Choice");
						}
					}
					break;
				
				case 2:
						nriloop:
					    while (flag) {

					        System.out.println("===== NRI RESIDENT MENU =====");
					        System.out.println("1. Add NRI Resident");
					        System.out.println("2. Update Phone Number");
					        System.out.println("3. Update Occupancy");
					        System.out.println("4. View NRI Resident");
					        System.out.println("5. Delete NRI Resident");
					        System.out.println("6. View All NRI Residents");
					        System.out.println("7. Back");

					        int choice2 = sc.nextInt();
					        sc.nextLine();

					        switch (choice2) {

					            case 1:
					                System.out.println("Enter NRI Resident details:");
					                System.out.println("Name:Age:Gender:Contact:Email:Address:Adults:ChildrenAbove12:ChildrenAbove5:Duration:ResidentType:PassportNo:PassportType:Nationality:Purpose");

					                String input = sc.nextLine();

					                boolean addResult =NRI.addNRIResidentList(input);

					                if (addResult)
					                    System.out.println("NRI Resident added successfully");
					                else
					                    System.out.println("NRI Resident not added");
					                break;

					            case 2:
					                System.out.println("Enter Resident ID:");
					                String phoneResidentId = sc.nextLine();

					                System.out.println("Enter New Phone Number:");
					                long newPhone = sc.nextLong();
					                sc.nextLine();

					                boolean phoneResult =NRI.updateNRIResidentPhoneNumberUsingResidentId(phoneResidentId, newPhone);

					                if (phoneResult)
					                    System.out.println("Phone updated successfully");
					                else
					                    System.out.println("Phone not updated");
					                break;

					            case 3:
					                System.out.println("Enter Resident ID:");
					                String occupancyResidentId = sc.nextLine();

					                System.out.println("Enter Adults:");
					                int adults = sc.nextInt();

					                System.out.println("Enter Children Above 12:");
					                int above12 = sc.nextInt();

					                System.out.println("Enter Children Above 5:");
					                int above5 = sc.nextInt();
					                sc.nextLine();

					                boolean occupancyResult = NRI.updateOccupancyUsingResidentId( occupancyResidentId, adults, above12, above5);

					                if (occupancyResult)
					                    System.out.println("Occupancy updated successfully");
					                else
					                    System.out.println("Occupancy not updated");
					                break;

					            case 4:
					                System.out.println("Enter Resident ID:");
					                String viewResidentId = sc.nextLine();

					                NRIResident resident =NRI.retreiveNRIResidentDetails(viewResidentId);

					                if (resident != null) {
					                    System.out.println("Resident ID: " + resident.getResidentId());
					                    System.out.println("Name: " + resident.getResidentName());
					                    System.out.println("Age: " + resident.getAge());
					                    System.out.println("Gender: " + resident.getGender());
					                    System.out.println("Contact: " + resident.getContactNumber());
					                    System.out.println("Email: " + resident.getEmail());
					                    System.out.println("Address: " + resident.getAddress());
					                    System.out.println("Adults: " + resident.getNumberOfAdults());
					                    System.out.println("Children Above 12: " + resident.getNumberOfChildrenAbove12());
					                    System.out.println("Children Above 5: " + resident.getNumberOfChildrenAbove5());
					                    System.out.println("Duration: " + resident.getDurationOfStay());
					                    System.out.println("Resident Type: " + resident.getResidentType());
					                    System.out.println("Passport No: " + resident.getPassportNo());
					                    System.out.println("Passport Type: " + resident.getPassportType());
					                    System.out.println("Nationality: " + resident.getNationality());
					                    System.out.println("Purpose: " + resident.getPurposeForVisit());
					                } else {
					                    System.out.println("NRI Resident not found");
					                }
					                break;

					            case 5:
					                System.out.println("Enter Resident ID:");
					                String deleteResidentId = sc.nextLine();

					                boolean deleteResult =NRI.deleteNRIResidentDetailsFromDB(deleteResidentId);

					                if (deleteResult)
					                    System.out.println("NRI Resident deleted successfully");
					                else
					                    System.out.println("NRI Resident not deleted");
					                break;
					                
					            case 6:

					                List<NRIResident> residentList = NRI.viewAllNRIResidents();

					                for(NRIResident resident1 : residentList) {

					                    System.out.println("----------------");

					                    System.out.println("Resident ID: " + resident1.getResidentId());

					                    System.out.println("Name: " + resident1.getResidentName());

					                    System.out.println("Phone: " + resident1.getContactNumber());
					                    
					                }

					                break;

					            case 7:
					                
					                break nriloop;

					            default:
					                System.out.println("Invalid choice");
					        }
					    }
						break;
						
				
					
				case 3:
					bookingloop:
					while(flag) {
						 System.out.println("===== BOOKING MENU =====");
					        System.out.println("1. Add Booking");
					        System.out.println("2. Update Check-In and Check-Out Date");
					        System.out.println("3. Update Package");
					        System.out.println("4. Update Extra Access");
					        System.out.println("5. Cancel Booking");
					        System.out.println("6. View Booking Details");
					        System.out.println("7. View All Bookings");
					        System.out.println("8. Back");

					        System.out.println("Enter your choice:");
					        int choice2 = sc.nextInt();
					        sc.nextLine();
					        
					        switch (choice2) {

				            case 1:
				                System.out.println("Enter booking details:");
				                System.out.println("Format:");
				                System.out.println("ResidentId:ResidentName:Duration:Adults:ChildrenAbove12:ChildrenAbove5:CheckInDate:CheckOutDate:FloorNo:RoomNo:Package:AC:Pool:Gym");

				                String input = sc.nextLine();

				                List<String> bookingRecords = new ArrayList<String>();
				                bookingRecords.add(input);

				                List<Booking> bookingList =BS.buildBookingList(bookingRecords);

				                boolean addResult =BS.addBookingList(bookingList);

				                if (addResult) {
				                    System.out.println("Booking added successfully");
				                } else {
				                    System.out.println("Booking failed");
				                }
				                break;

				            case 2:
				                System.out.println("Enter Booking ID:");
				                String bookingIdForDate = sc.nextLine();

				                System.out.println("Enter new Check-In Date yyyy-mm-dd:");
				                LocalDate checkInDate =LocalDate.parse(sc.nextLine());

				                System.out.println("Enter new Check-Out Date yyyy-mm-dd:");
				                LocalDate checkOutDate =LocalDate.parse(sc.nextLine());

				                boolean dateResult =BS.updateCheckInAndCheckOutUsingBookingId(bookingIdForDate,checkInDate,checkOutDate);

				                if (dateResult) {
				                    System.out.println("Dates updated successfully");
				                } else {
				                    System.out.println("Date update failed");
				                }
				                break;

				            case 3:
				                System.out.println("Enter Booking ID:");
				                String bookingIdForPackage = sc.nextLine();

				                System.out.println("Enter Preferred Package:");
				                String preferredPackage = sc.nextLine();

				                boolean packageResult =BS.updatePackageUsingBookingId(bookingIdForPackage, preferredPackage);

				                if (packageResult) {
				                    System.out.println("Package updated successfully");
				                } else {
				                    System.out.println("Package update failed");
				                }
				                break;

				            case 4:
				                System.out.println("Enter Booking ID:");
				                String bookingIdForAccess = sc.nextLine();

				                System.out.println("Enter AC Access YES/NO:");
				                String acAccess = sc.nextLine();

				                System.out.println("Enter Pool Access YES/NO:");
				                String poolAccess = sc.nextLine();

				                System.out.println("Enter Gym Access YES/NO:");
				                String gymAccess = sc.nextLine();

				                boolean accessResult =BS.updateExtraAccessUsingBookingId(bookingIdForAccess,acAccess,poolAccess,gymAccess);

				                if (accessResult) {
				                    System.out.println("Extra access updated successfully");
				                } else {
				                    System.out.println("Extra access update failed");
				                }
				                break;

				            case 5:
				                System.out.println("Enter Booking ID:");
				                String cancelBookingId = sc.nextLine();

				                boolean cancelResult =BS.cancelBookingFromDB(cancelBookingId);

				                if (cancelResult) {
				                    System.out.println("Booking cancelled successfully");
				                } else {
				                    System.out.println("Booking cancellation failed");
				                }
				                break;

				            case 6:
				                System.out.println("Enter Booking ID:");
				                String viewBookingId = sc.nextLine();

				                Booking booking =BS.viewBookingDetails(viewBookingId);

				                if (booking != null) {
				                    System.out.println("Booking ID: " + booking.getBookingId());
				                    System.out.println("Resident ID: " + booking.getResidentId());
				                    System.out.println("Resident Name: " + booking.getResidentName());
				                    System.out.println("Duration: " + booking.getDurationOfStay());
				                    System.out.println("Adults: " + booking.getNumberOfAdults());
				                    System.out.println("Children Above 12: " + booking.getNumberOfChildrenAbove12());
				                    System.out.println("Children Above 5: " + booking.getNumberOfChildrenAbove5());
				                    System.out.println("Check-In Date: " + booking.getCheckInDate());
				                    System.out.println("Check-Out Date: " + booking.getCheckOutDate());
				                    System.out.println("Floor Number: " + booking.getFloornumber());
				                    System.out.println("Room Number: " + booking.getRoomNumber());
				                    System.out.println("Package: " + booking.getPreferredPackage());
				                    System.out.println("AC Access: " + booking.getAcAccess());
				                    System.out.println("Pool Access: " + booking.getPoolAccess());
				                    System.out.println("Gym Access: " + booking.getGymAccess());
				                } else {
				                    System.out.println("Booking not found");
				                }
				                break;
				                
				            case 7:

				                List<Booking> bookingList1 = BS.viewAllBookings();

				                BookingList(bookingList1);

				                break;


				            case 8:
				                
				                break bookingloop;
				                
				            default:
				                System.out.println("Invalid choice");
				        }				
					}
					break;

				case 4:
						paymentloop:
					    while(flag) {

					        System.out.println("===== PAYMENT MENU =====");
					        System.out.println("1. Add Payment");
					        System.out.println("2. View Payment Details");
					        System.out.println("3. View All Payments");
					        System.out.println("4. Back");

					        System.out.println("Enter your choice:");

					        int choice4 = sc.nextInt();
					        sc.nextLine();

					        switch(choice4) {

					        case 1:

					            System.out.println("Enter payment details:");
					            System.out.println("Format:");
					            System.out.println("BookingId:ResidentName:FloorNo:RoomNo:CheckInDate:CheckOutDate:PaymentDate:PaymentMethod:BillAmount");

					            String input = sc.nextLine();

					            List<String> paymentRecords =new ArrayList<String>();

					            paymentRecords.add(input);

					            List<Payment> paymentList =PS.buildPaymentList(paymentRecords);

					            boolean addResult =PS.addPaymentList(paymentList);

					            if(addResult) {

					                System.out.println("Payment added successfully");
					            }

					            else {

					                System.out.println("Payment failed");
					            }

					            break;

					        case 2:

					            System.out.println("Enter Payment ID:");

					            String paymentId =sc.nextLine();

					            Payment payment =PS.viewPaymentDetails(paymentId);

					            if(payment != null) {

					                System.out.println("Payment ID: "+ payment.getPaymentId());

					                System.out.println("Booking ID: "+ payment.getBookingId());

					                System.out.println("Resident Name: "+ payment.getResidentName());

					                System.out.println("Floor Number: "+ payment.getFloorNumber());

					                System.out.println("Room Number: "+ payment.getRoomNumber());

					                System.out.println("Check-In Date: "+ payment.getCheckInDate());

					                System.out.println( "Check-Out Date: "+ payment.getCheckOutDate());

					                System.out.println("Payment Date: "+ payment.getPaymentDate());

					                System.out.println("Payment Method: "+ payment.getPaymentMethod());

					                System.out.println("Bill Amount: "+ payment.getBillAmount());
					            }

					            else {

					                System.out.println("Payment not found");
					            }

					            break;
					            
					        case 3:

					            List<Payment> paymentList1 = PS.viewAllPayments();

					            for(Payment payment1 : paymentList1) {

					                System.out.println("----------------");

					                System.out.println("Payment ID: " + payment1.getPaymentId());

					                System.out.println("Booking ID: " + payment1.getBookingId());

					                System.out.println("Resident Name: " + payment1.getResidentName());

					                System.out.println("Bill Amount: " + payment1.getBillAmount());
					            }

					            break;



					        case 4:
					            
					            break paymentloop;
					            
					        default:

					            System.out.println("Invalid choice");
					        }
					    }
						break;
					}
				
				}
			
			else if(option==2) {
					managerloop:
				    while (flag) {

				        System.out.println("===== MANAGER MENU =====");
				        System.out.println("1. Room Management");
				        System.out.println("2. View Booking Details");
				        System.out.println("3. View Available Rooms");
				        System.out.println("4. View Occupied Rooms");
				        System.out.println("5. View Available Rooms By Floor");
				        System.out.println("6. View Occupied Rooms By Floor");
				        System.out.println("7. View Bookings By Check-In Date");
				        System.out.println("8. View Bookings By Check-Out Date");
				        System.out.println("9. View All Bookings");
				        System.out.println("10. Back");
				        
				        int choice = sc.nextInt();
				        sc.nextLine();

				        switch (choice) {
				        
				        case 1:
							roomloop:
						    while (flag) {

						        System.out.println("===== ROOM MENU =====");
						        System.out.println("1. Add Room");
						        System.out.println("2. Delete Room Using Floor Number");
						        System.out.println("3. Delete Room Using Room Number");
						        System.out.println("4. View All Rooms");
						        System.out.println("5. Back");

						        int choice3 = sc.nextInt();
						        sc.nextLine();

						        switch (choice3) {

						            case 1:
						                System.out.println("Enter room details:");
						                System.out.println("RoomNo:FloorNo:MaxOccupancy:HasAC:HasPool:HasGym");

						                String input = sc.nextLine();

						                List<String> roomRecords =new ArrayList<String>();

						                roomRecords.add(input);

						                List<Room> roomList =RS.buildRoomList(roomRecords);

						                boolean addResult =RS.addRoomList(roomList);
						                                

						                if (addResult)
						                    System.out.println("Room added successfully");
						                else
						                    System.out.println("Room not added");
						                break;
						                
						            case 2:
						                System.out.println("Enter Floor Number:");
						                String floorNumber = sc.nextLine();

						                boolean floorDelete =RS.deleteRoomDetailsFromDBUsingFloorNumber(floorNumber);

						                if (floorDelete)
						                    System.out.println("Rooms deleted successfully");
						                else
						                    System.out.println("No rooms deleted");
						                break;

						            case 3:
						                System.out.println("Enter Room Number:");
						                String deleteRoomNo = sc.nextLine();

						                boolean roomDelete =RS.deleteRoomDetailsFromDBUsingRoomNumber(deleteRoomNo);

						                if (roomDelete)
						                    System.out.println("Room deleted successfully");
						                else
						                    System.out.println("Room not deleted");
						                break;
						                
						            case 4:

						                List<Room> roomList1 = RS.viewAllRooms();

						                RoomList(roomList1);

						                break;
						           
						            case 5:
						                
						                break roomloop;
						                
						            default:
						                System.out.println("Invalid choice");
						        }
						    }
							break;

				            case 2:
				                System.out.println("Enter Booking ID:");
				                String bookingId = sc.nextLine();

				                Booking booking = MS.viewBookingDetails(bookingId);

				                if (booking != null) {
				                    System.out.println("Booking ID: " + booking.getBookingId());
				                    System.out.println("Resident ID: " + booking.getResidentId());
				                    System.out.println("Resident Name: " + booking.getResidentName());
				                    System.out.println("Room Number: " + booking.getRoomNumber());
				                    System.out.println("Check-In: " + booking.getCheckInDate());
				                    System.out.println("Check-Out: " + booking.getCheckOutDate());
				                } else {
				                    System.out.println("Booking not found");
				                }
				                break;

				            case 3:
				                RoomList(MS.viewAvailableRoom());
				                break;

				            case 4:
				                RoomList(MS.viewOccupiedRoom());
				                break;

				            case 5:
				                System.out.println("Enter Floor Number:");
				                String availableFloor = sc.nextLine();

				                RoomList(MS.viewAvailableRoomForParticularFloorNumber(availableFloor));
				                break;

				            case 6:
				                System.out.println("Enter Floor Number:");
				                String occupiedFloor = sc.nextLine();

				                RoomList(MS.viewOccupiedRoomForParticularFloorNumber(occupiedFloor));
				                break;

				            case 7:
				                System.out.println("Enter Check-In Date yyyy-mm-dd:");
				                LocalDate checkInDate = LocalDate.parse(sc.nextLine());

				                BookingList(MS.viewOccupiedRoomForParticularCheckInDate(checkInDate));
				                break;

				            case 8:
				                System.out.println("Enter Check-Out Date yyyy-mm-dd:");
				                LocalDate checkOutDate = LocalDate.parse(sc.nextLine());

				                BookingList(MS.viewOccupiedRoomForParticularCheckOutDate(checkOutDate));
				                break;
				            case 9:

				                List<Booking> bookingList = MS.viewAllBookings();

				                ManagerBookingList(bookingList);

				                break;

				            case 10:

				                break managerloop;
				           
				            default:
				                System.out.println("Invalid choice");
				        }
				    }
				}
			
			else if(option==3) {
				return;
			}
			}
			
				
			}
			
	public static void RoomList(List<Room> roomList) {

	    if (roomList.isEmpty()) {

	        System.out.println("No rooms found");

	        return;
	    }

	    for (Room room : roomList) {

	        System.out.println("-------------------");

	        System.out.println("Room Number: "+ room.getRoomNumber());

	        System.out.println("Floor Number: "+ room.getFloorNumber());

	        System.out.println("Occupied: "+ room.getIsOccupied());

	        System.out.println("Max Occupancy: "+ room.getMaxOccupancy());

	        System.out.println("AC: "+ room.getHasAc());

	        System.out.println("Pool Access: "+ room.getHasSwimmingPoolAccess());

	        System.out.println("Gym Access: "+ room.getHasGymAccess());
	    }
	}
			
	public static void BookingList(List<Booking> bookingList) {

	    if (bookingList.isEmpty()) {

	        System.out.println("No bookings found");

	        return;
	    }

	    for (Booking booking : bookingList) {

	        System.out.println("-------------------");

	        System.out.println("Booking ID: "+ booking.getBookingId());

	        System.out.println("Resident ID: "+ booking.getResidentId());

	        System.out.println("Resident Name: "+ booking.getResidentName());

	        System.out.println("Room Number: "+ booking.getRoomNumber());

	        System.out.println("Check-In Date: "+ booking.getCheckInDate());

	        System.out.println("Check-Out Date: "+ booking.getCheckOutDate());
	    }
	}
	
	public static void ManagerBookingList(List<Booking> bookingList) {

	    if(bookingList == null || bookingList.isEmpty()) {

	        System.out.println("No bookings found");

	        return;
	    }

	    for(Booking booking : bookingList) {

	        System.out.println("----------------");

	        System.out.println("Booking ID: " + booking.getBookingId());

	        System.out.println("Resident Name: " + booking.getResidentName());
	    }
	}
	
}
		



