package vn.aptech;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SinhVien {

	private int id;
	private String Fullname;
	private String Phone;
	private String Address;
	
	public SinhVien() {
		
	}
	
	public SinhVien(int id,String name, String phone, String address ) {
		this.id = id;
		this.Fullname = name;
		this.Phone = phone;
		this.Address = address;
	}
	
	public String outPutInfo() {
		return "Thong tin sinh vien: ID: "+id+" Fullname: "+Fullname+" Phone: " + Phone + " Address: " + Address;
	}
	
	public int getId() {
		return id;
	}

	public String getFullname() {
		return Fullname;
	}

	public String getPhone() {
		return Phone;
	}

	public String getAddress() {
		return Address;
	}
	
    public void setId(int id) {
        if (SinhVienValidator.validateId(id)) {
            this.id = id;
        } else {
            System.out.println("Invalid ID. Please enter a positive integer.");
        }
    }

    public void setFullname(String fullname) {
        if (SinhVienValidator.validateFullName(fullname)) {
            this.Fullname = fullname;
        } else {
            System.out.println("Invalid full name. Please enter a non-empty string.");
        }
    }

    public void setPhone(String phone) {
        if (SinhVienValidator.validatePhoneNumber(phone)) {
            this.Phone = phone;
        } else {
            System.out.println("Invalid phone number. Please enter a non-empty string.");
        }
    }

    public void setAddress(String address) {
        if (SinhVienValidator.validateAddress(address)) {
            this.Address = address;
        } else {
            System.out.println("Invalid address. Please enter a non-empty string.");
        }
    }

	
	public void InputInfo(Scanner sc, ArrayList lst) {
		    System.out.println("Nhap id sinh vien: ");
		    int getId = Integer.parseInt(sc.nextLine());
		    
		    System.out.println("Nhap ho va ten sinh vien: ");
		    String getName = sc.nextLine();
		    
		    System.out.println("Nhap so dien thoai sinh vien: ");
		    String getPhone = sc.nextLine();
		    
		    System.out.println("Nhap dia chi: ");
		    String getAdd = sc.nextLine();
		    
		    SinhVien sv = new SinhVien();
		    sv.setId(getId);
		    sv.setFullname(getName);
		    sv.setPhone(getPhone);
		    sv.setAddress(getAdd);
		    
		    lst.add(sv);

	}
	
	public void UpdateInfo(Scanner sc) {
		System.out.println("Nhap ho va ten sinh vien: ");
		String getName = sc.nextLine();
		this.setFullname(getName);
		System.out.println("Nhap so dien thoai sinh vien: ");
		String getPhone = sc.nextLine();
		this.setPhone(getPhone);
		System.out.println("Nhap dia chi: ");
		String getAdd = sc.nextLine();
		this.setAddress(getAdd);
		
	}
	
	public void WriteToFile(String fileName,ArrayList<SinhVien> lst) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (SinhVien student : lst) {
                String temp = String.format(
                        "%s|%s|%s|%s",student.getId(),student.getFullname(),student.getPhone(),student.getAddress());
                writer.write(temp);
				writer.newLine();
            }
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    boolean ct = true;
	    ArrayList<SinhVien> lst = new ArrayList<>();
	    MenuList menu = new MenuList();
	    SinhVien sv = new SinhVien();
	    
	    while (ct) {
	        int check = 0;
	        while (true) {
	            try {
	                menu.OutputMenu();
	                System.out.println("Nhap yeu cau: ");
	                check = Integer.parseInt(sc.nextLine());
	                if (check < 1 || check > 6) {
	                    System.out.println("Nhap tu 1 den 6!");
	                    continue;
	                }
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a valid number.");
	            }
	        }
	        
	        switch (check) {
	            case 1:
	                boolean k = true;
	                while (k) {
	                    sv.InputInfo(sc, lst);
	                    System.out.println("Ban co muon them thong tin khong?:");
	                    String loop = sc.nextLine();
	                    if (loop.equalsIgnoreCase("n")) {
	                        k = false;
	                    } else {
	                        k = true;
	                    }
	                }
	                break;
	            case 2:
	                for (SinhVien i : lst) {
	                    System.out.println(i.outPutInfo());
	                }
	                break;
	            case 3:
	                int getid = -1, selected = -1;
	                System.out.println("Nhap ma sinh vien muon cap nhat thong tin: ");
	                getid = Integer.parseInt(sc.nextLine());
	                for (int i = 0; i < lst.size(); i++) {
	                    if (lst.get(i).getId() == getid) {
	                        selected = i;
	                        break;
	                    }
	                }
	                if (selected != -1) {
	                    SinhVien up_sv = lst.get(selected);
	                    up_sv.UpdateInfo(sc);
	                    System.out.println("Thong tin sinh vien da duoc cap nhat!");
	                }
	                break;
	            case 4:
	                int checkid = -1, deleted = -1;
	                System.out.println("Nhap ma sinh vien muon xoa: ");
	                checkid = Integer.parseInt(sc.nextLine());
	                for (int i = 0; i < lst.size(); i++) {
	                    if (lst.get(i).getId() == checkid) {
	                        deleted = i;
	                        break;
	                    }
	                }
	                if (deleted != -1) {
	                    lst.remove(deleted);
	                    System.out.println("Sinh vien co ma " + checkid + " da bi xoa!");
	                } else {
	                    System.out.println("Sinh vien khong ton tai!");
	                }
	                break;
	            case 5:
	                System.out.println("Nhap ten file can xuat:");
	                String getfile = sc.nextLine();
	                sv.WriteToFile(getfile, lst);
	                break;
	            default:
	                System.exit(0);
	        }
	    }


		
		
	}

}
