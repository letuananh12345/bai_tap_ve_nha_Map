import sun.awt.SunHints;

import java.util.*;


public class QuanLyCongNhan {
    HashMap<String, CongNhan> congNhanMap = null;
    Scanner sc = new Scanner(System.in);

    public QuanLyCongNhan() {
       congNhanMap = new HashMap<>();

    }

    public QuanLyCongNhan(HashMap<String, CongNhan> congNhanMap) {
        this.congNhanMap = congNhanMap;
    }

    public void addCongNhan() {
        System.out.println("Nhập id :");
        String id = sc.nextLine();
        System.out.println("Nhập name :");
        String name = sc.nextLine();
        System.out.println("Nhập age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập part :");
        String part = sc.nextLine();
        System.out.println("Nhập địa chỉ : ");
        String address = sc.nextLine();
      CongNhan congNhan =new CongNhan(id,name,age,part,address);
       congNhanMap.put(congNhan.getId(), congNhan);
    }

    public void display() {
        Set<String> keys = congNhanMap.keySet();
        for (String key : keys) {
            System.out.println(congNhanMap.get(key));
        }
    }

    public String checkByID() {
        Set<String> keys = congNhanMap.keySet();
        System.out.println("Enter ID:");
        String id = sc.nextLine();
        CongNhan st = congNhanMap.get(id);
        for (String key : keys) {
            if (key.equals(id)) {
                return key;
            }
        }
        return null;
    }

    public void findByID() {
        String result = checkByID();
        if (result == null) {
            System.out.println("Can't find this ID");
        } else {
            System.out.println("Có");
        }
    }

    public void findByName() {
        String result = checkByName();
        if (result == null) {
            System.out.println("Nothing!");
        } else {
            System.out.println(congNhanMap.get(result));
        }

    }

    public String checkByName() {
        Set<String> keys = congNhanMap.keySet();
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        for (String key : keys) {
                if (congNhanMap.get(key).getName().equals(name)) {
                return key;
            }
        }
        return null;
    }

    public void deleteByID() {
        String result = checkByID();
        if (result != null) {
            congNhanMap.remove(result);
        } else {
            System.out.println("Nothing!");
        }
    }
    public void deleteByName() {
        String result = checkByName();
        if (result == null) {
            System.out.println("No have this name");
        } else {
            congNhanMap.remove(result);
        }
    }

    public void editByName() {
        String result = checkByName();
        if (result == null) {
            System.out.println("No this name");
        } else {
            Set<Map.Entry<String, CongNhan>> entries = congNhanMap.entrySet();
            List<Map.Entry<String, CongNhan>> listEntries = new ArrayList<>(entries);
            for (Map.Entry<String, CongNhan> entry : listEntries) {
                if (entry.getKey() == result) {
                    editInformation(entry.getValue());
                }
            }
        }
    }

    public void editInformation(CongNhan a) {
        System.out.println("Name is");
        String name = sc.nextLine();
        if (name != null) {
            a.setName(name);
        }
        System.out.println("Age is");
        int age = sc.nextInt();
        sc.nextLine();
        if (age != 0) {
            a.setAge(age);
        }
        System.out.println("Address is :");
        String address = sc.nextLine();
        if (address != null) {
            a.setAddress(address);
        }
    }

    public void sortByName() {
        Set<Map.Entry<String, CongNhan>> entries = congNhanMap.entrySet();
        List<Map.Entry<String, CongNhan>> listEntries = new ArrayList<>(entries);
        Collections.sort(listEntries, new Comparator<Map.Entry<String, CongNhan>>() {
            @Override
            public int compare(Map.Entry<String, CongNhan> o1, Map.Entry<String, CongNhan> o2) {
                return o1.getValue().getName().compareTo(o2.getValue().getName());
            }
        });
        LinkedHashMap<String, CongNhan> sortedstudentMap = new LinkedHashMap<>(listEntries.size());
        for (Map.Entry<String,CongNhan> entry : listEntries) {
            sortedstudentMap.put(entry.getKey(), entry.getValue());
        }
        this.congNhanMap = sortedstudentMap;
    }

    public void sortByAge() {
        Set<Map.Entry<String, CongNhan>> entries = congNhanMap.entrySet();
        List<Map.Entry<String, CongNhan>> listEntries = new ArrayList<>(entries);
        Collections.sort(listEntries, new Comparator<Map.Entry<String,CongNhan>>() {
            @Override
            public int compare(Map.Entry<String, CongNhan> o1, Map.Entry<String, CongNhan> o2) {
                return o1.getValue().getAge() - o2.getValue().getAge();
            }
        });
        LinkedHashMap<String, CongNhan> sortedstudentMap = new LinkedHashMap<>(listEntries.size());
        for (Map.Entry<String, CongNhan> entry : listEntries) {
            sortedstudentMap.put(entry.getKey(), entry.getValue());
        }
        this.congNhanMap = sortedstudentMap;
    }

}
