package ua.com;

import ua.com.model.Address;
import ua.com.model.Passport;
import ua.com.model.Skill;
import ua.com.model.User;
import ua.com.service.AddressService;
import ua.com.service.PassportService;
import ua.com.service.SkillService;
import ua.com.service.UserService;
import ua.com.util.SessionConnector;

public class Main {
  public static void main(String[] args) {

    UserService us = new UserService();
    SkillService ss = new SkillService();
    AddressService as = new AddressService();
    PassportService ps = new PassportService();

    //create

//    User user1 = new User("Frank", "Jackson", "frank@gmail.com");
//    User user2 = new User("Bill", "Urbinov", "bill@gmail.ru");
//    User user3 = new User ("Sam", "White", "sam@mail.ru");
//
//    us.insert(user1);
//    us.insert(user2);
//    us.insert(user3);
//
//    Skill skill1 = new Skill("Java");
//    Skill skill2 = new Skill("C#");
//    Skill skill3 = new Skill("C");
//    Skill skill4 = new Skill("C++");
//
//    ss.insert(skill1);
//    ss.insert(skill2);
//    ss.insert(skill3);
//    ss.insert(skill4);
//
//
//    Address address1= new Address("Vonka", 5, "93htx852");
//    Address address2= new Address("Baicker", 7, "2cx85t");
//    Address address3= new Address("Arbochova", 0, "95yx59xm25");
//    Address address4= new Address("Popochina", 67, "7c467xgn");
//    Address address5= new Address("Danilisa", 24, "xf287hf8gh");
//
//    as.insert(address1);
//    as.insert(address2);
//    as.insert(address3);
//    as.insert(address4);
//    as.insert(address5);
//
//    Passport passport1 = new Passport("GB", "98xn532");
//    Passport passport2 = new Passport("UKR", "01x2mu");
//    Passport passport3 = new Passport("RUS", "86x234n");
//    Passport passport4 = new Passport("USA", "02im9mmh2x5");
//
//    ps.insert(passport1);
//    ps.insert(passport2);
//    ps.insert(passport3);
//    ps.insert(passport4);

//select and update

    User user1 = us.selectById(1);
    User user2 = us.selectById(2);
    User user3 = us.selectById(3);

    Skill skill1 = ss.selectById(1);
    Skill skill2 = ss.selectById(2);
    Skill skill3 = ss.selectById(3);

    Passport passport1 = ps.selectById(1);
    Passport passport2 = ps.selectById(2);
    Passport passport3 = ps.selectById(3);

    Address address1 = as.selectById(1);
    Address address2 = as.selectById(2);
    Address address3 = as.selectById(3);
//
//
//    us.addSkill(skill1, user1);
//    us.addSkill(skill2, user1);
//    us.addSkill(skill1, user2);
//    us.addSkill(skill3, user2);
//    us.addSkill(skill1, user3);
//
//    us.removeSkill(user1, skill2);
//
//    us.addPassport(passport1, user1);
//    us.addPassport(passport3, user2);
//    us.addPassport(passport2, user3);
//
//    us.deletePassport(user2);
//
//    us.addAddress(user1, address1);
//    us.addAddress(user1, address2);
//    us.addAddress(user2, address3);
//    us.addAddress(user3, address3);
//
//    us.deleteAddress(user1, address1);

    //delete

    us.remove(user1);
    as.remove(address2);
    ss.remove(skill3);
    ps.remove(passport1);
  }
}
