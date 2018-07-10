import java.util.*;
import java.io.*;

public class Payment {

		String PaymentMode;
		long Buyer_ac_no;
		long Seller_ac_no;
		String PaymentStatus;
		int BuyerID;
		int SellerID;
		public Payment(int buyerID, int sellerID) 
		{	
			BuyerID = buyerID;
			SellerID = sellerID;
		}
		protected String getPaymentMode() 
		{
			return PaymentMode;
		}
		protected void setPaymentMode(String paymentMode) 
		{
			PaymentMode = paymentMode;
		}
		protected long getBuyer_ac_no()
		{
			return Buyer_ac_no;
		}
		protected void setBuyer_ac_no(long buyer_ac_no)
		{
			Buyer_ac_no = buyer_ac_no;
		}
		protected long getSeller_ac_no() 
		{
			return Seller_ac_no;
		}
		protected void setSeller_ac_no(long seller_ac_no) 
		{
			Seller_ac_no = seller_ac_no;
		}
		protected String getPaymentStatus()
		{
			return PaymentStatus;
		}
		protected void setPaymentStatus(String paymentStatus)
		{
			PaymentStatus = paymentStatus;
		}
		protected int getBuyerID()
		{
			return BuyerID;
		}
		protected void setBuyerID(int buyerID)
		{
			BuyerID = buyerID;
		}
		protected int getSellerID() {
			return SellerID;
		}
		protected void setSellerID(int sellerID) {
			SellerID = sellerID;
		}
		
		public void doPayment() 
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Select Mode Of Payment");
			System.out.println("1.Net Banking");
			System.out.println("2.Debit Card");
			System.out.println("3.Credit Card");
			System.out.println("4.Paytm");
			
			int n = sc.nextInt();
			
			if(n==1)
				this.setPaymentMode("Net_Banking");
			else if(n==2)
				this.setPaymentMode("Debit_Card");
			else if(n==3)
				this.setPaymentMode("Credit_Card");
			else
				this.setPaymentMode("Paytm");
		
			System.out.println("please provide a/c :");
			System.out.println("please provide payee a/c");
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			this.setPaymentStatus("Approved");
			this.setBuyer_ac_no(s1);
			this.setSeller_ac_no(s2);
			PrintWriter pw = new PrintWriter(System.out);
			pw.append(this.PaymentMode+" "+this.getBuyer_ac_no()+ " "+this.BuyerID+" "+this.SellerID+" "+this.getSeller_ac_no()+" "+this.PaymentStatus+"\n");
			pw.close();
			sc.close();
			
		}
		
		
}