package com.wipro.bank.acc;

abstract class Account {
	int tenure;
	float principal;
	public float rateOfInterest;
	public void setInterest(int age, String gender)
	{
		if(gender=="male" &&age<=60)
		{
			rateOfInterest=(float) 9.8;
		}
		if(gender=="male" &&age>=60)
		{
			rateOfInterest=(float)10.5;
		}
		if(gender=="female" &&age<58)
		{
			rateOfInterest=(float)10.2;
		}
		if(gender=="female" &&age>=58)
		{
			rateOfInterest=(float)10.8;
		}
		
	}
	public float calculateMaturityAmount(float totalPrincipleDeposited, 
			float maturityInterest)
	{
		float maturity=(float) (totalPrincipleDeposited+maturityInterest);
		return maturity;
		
	}
	public abstract float calculateInterest();
	{
		
	}
	public abstract float calculateAmountDeposited();
	{
		
	}
}
public class RDAccount extends Account
{
	public RDAccount(int tenure, float principal)
	{
		this.tenure=tenure;
		this.principal=principal;
	}
	public float calculateAmountDeposited()
	{
	    float ans=(float)principal*tenure*12;
	    return ans;
	}
	public float calculateInterest()
	{
		int a=(int) (principal);
		int b=(int)(tenure);
		float r= rateOfInterest;
		float r1=(float)r/100;
		float m=1+r1/4;
		float intrest=0;
		int ty=b*12;
		for(int i=ty;i>0;i--)
		{
			float t=(float)i/12;
			float nt=(float)4*t;
			float ans1=(float)(Math.pow(m, nt));
			float ans2=(float)ans1-1;
			intrest=(float)intrest+(a*ans2);
		}
		
		return intrest;
		
	}

}