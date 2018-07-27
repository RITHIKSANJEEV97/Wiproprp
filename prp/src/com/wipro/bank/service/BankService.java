package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {
	public boolean validateData(float principal, int tenure,int age, String gender)
	{
		int c=0;
		BankValidationException a11=new BankValidationException();
		if((principal>=500 && tenure ==5 || tenure==10) && (gender=="male" || gender=="female")&&(age>=1 && age<=100))
		{
			c++;
			return true;
		}
		if(c==0)
		{
			
		   String a=a11.toString();
		   System.out.println(a);
		}
		return false;
	
	}
	public void calculate(float principal,int tenure, int age, String gender)
	{
		BankService a=new BankService();
		boolean c=a.validateData(principal, tenure, age, gender);
		if(c==true)
		{
			RDAccount obj1=new RDAccount(tenure,principal);
			obj1.setInterest(age, gender);
			//float x=(float) obj1.rateOfInterest;
			//System.out.println(x);
			float maturityInterest= (float)obj1.calculateInterest();
			System.out.printf("maturityInterest  is------------>"+"%.2f"+"\n",maturityInterest);
			float totalPrincipleDeposited=(float)obj1.calculateAmountDeposited();
			System.out.println("totalPrincipleDeposited is------>"+(int)totalPrincipleDeposited);
			float mat=(float)obj1.calculateMaturityAmount(totalPrincipleDeposited, maturityInterest);
			System.out.printf("Maturity amount is---------------->"+"%.2f"+"\n",mat);
			//System.out.println("correct");
		}
	}
	

}
