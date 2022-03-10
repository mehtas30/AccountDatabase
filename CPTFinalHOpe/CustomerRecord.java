import java.util.*;
public class CustomerRecord
{
    private String firstName, lastName, address, telephone, age, income;

    public CustomerRecord (String informationCustomer)
    {
	StringTokenizer st = new StringTokenizer (informationCustomer, "/");
	this.lastName = st.nextToken ();
	this.firstName = st.nextToken ();
	this.address = st.nextToken ();
	this.age = st.nextToken ();
	this.telephone = st.nextToken ();
	this.income = st.nextToken ();
    }
    
    public String getIncome ()
    {
	return income;
    }


    public String getTelephone ()
    {
	return telephone;
    }


    public String getAge ()
    {
	return age;
    }


    public String getAddress ()
    {
	return address;
    }


    public String getFirstName ()
    {
	return firstName;
    }


    public String getLastName ()
    {
	return lastName;
    }
}
