public class Member {

    private String memberId;
    private String name;
    private String phoneNumber;

    // Constructor
    public Member(String memberId, String name, String phoneNumber) {

        this.memberId = memberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Display Member

    public void displayMember() {

        System.out.println("------------------------------");
        System.out.println("Member ID    : " + memberId);
        System.out.println("Name         : " + name);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.println("------------------------------");
    }
}