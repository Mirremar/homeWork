package Family.Interfaces;

import Family.FamilyTree.Gender;

import java.time.LocalDate;
import java.util.List;

public interface Entity<T> {
    T getFather();
    T getMother();

    Gender getGender();
    String getName();
    LocalDate getDob();
    LocalDate getDod();
    List<T> getChildren();
    int getage();

    void setName(String newName);

    void setDob(LocalDate parse);

    void setGender(Gender male);

    void setFather(T father);

    void setMother(T mother);


}
