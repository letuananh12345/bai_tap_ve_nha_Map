import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            QuanLyCongNhan quanLyCongNhan=new QuanLyCongNhan();
            Scanner sc = new Scanner(System.in);
            System.out.println("quan ly cong nhan");
            while (true){
                System.out.println("Menu:");
                System.out.println("1.Display.");
                System.out.println("2.thêm mới công nhân .");
                System.out.println("3.tìm kiếm theo id");
                System.out.println("4.tìm kiếm theo tên");
                System.out.println("5.xóa theo id");
                System.out.println("6.sửa theo tên");
                System.out.println("7.sửa theo tuổi ");
                System.out.println("8.sắp sếp theo tên");
                System.out.println("0.Exit");
                System.out.println("Enter your choice:");
                int choice=sc.nextInt();
                switch (choice){
                    case 1:
                        quanLyCongNhan.display();
                        break;
                    case 2:
                        quanLyCongNhan.addCongNhan();
                        break;
                    case 3:
                        quanLyCongNhan.findByID();
                        break;
                    case 4:
                        quanLyCongNhan.findByName();
                        break;
                    case 5:
                        quanLyCongNhan.deleteByID();
                        break;
                    case 6:
                        quanLyCongNhan.editByName();
                        break;
                    case 7:
                        quanLyCongNhan.sortByAge();
                        break;
                    case 8:
                        quanLyCongNhan.sortByName();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn k đúng : ");
                        break;
                }
            }
        }
    }

