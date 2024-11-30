#include<stdio.h>
int main()
{
    int n, i,value;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter elements:\n");
    for (i = 0; i < n; i++) 
    scanf("%d", &arr[i]);
    for (i = 0; i < n; i++) 
    printf("%d\t",arr[i]);
    printf("\n");
    printf("Enter the key");
    scanf("%d",&value);
    int position=-1;
    for(int i=0;i<n;i++){
        if(value==arr[i])
        {
            position=i+1;
            break;
        }
    }
    if(position==-1){
        printf("Not Found");
    }
    else
    printf("The positon of %d is %d",value,position);

}