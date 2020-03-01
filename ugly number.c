#include<stdio.h>

int two(int ,int );
int isUgly(int );
int main()
{
    int n;
    printf("enter no.\n");
    scanf("%d",&n);
    if(isUgly(n))
    printf("ugly no.");
    else
    printf("not a ugly no.");
}


int isUgly(int n){
    
    int l,m,k;
    if(n!=0)
    {
    n=two(n,2);
    n=two(n,3);
    n=two(n,5);
        
        if(n==1)
    return 1;
    return 0;
    }
 else
     return 0;
}


int two(int n,int a)
{
    
    if(n%a!=0)
        return n;
    else
        return two(n/a,a);
}
