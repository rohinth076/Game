#include<stdio.h>
int main()
{
	int n,s;
	printf("\n\t\t\t\tMATCH STICK GAME");
	printf("\nRULES:\n1.THERE ARE 21 MATCH STICK INITIALLY");
	printf("\n2.THE GAME BETWEEN USER AND COMPUTER");
	printf("\n3.FIRST USER TAKE MATCH STICK COUNT OF 1 TO 4");
	printf("\n4.WHO TAKE LAST MATCH STICK IS LOSSER");
	n = 21;
	printf("\n GAME STARTS");
	while(n>1)
	{
		printf("\nYOUR TURN!!");
		scanf("%d",&s);
		if(s>=1 && s<=4)
			{
				printf("\nCOMPUTER TAKES %d MATCH STICKS",5-s);
				n = n - 5;
				printf("\nREMAINING MATCH STICKS:%d",n);
			}
		else
		{
			printf("\nWRONG CHIOSE!! ");
			printf("\nTAKE MATCH STICK BETWEEN 1 TO 4");
		}
		if(n==1)
			printf("\nCOMPUTER WINS");
	}
	return 0;

}
