# include <stdio.h>
# include <stdlib.h>
# include <string.h>
#include <ctype.h>
struct node {
    char acc[20];
    char pass[20];
    int sta ;
    struct Node * next;
};
struct node * makeNode(char tk[20], char mk[20],int status){
 struct node *p = (struct node*)malloc(sizeof(struct node));
    if (p == NULL) return NULL;
    else {
        strcpy(p->acc,tk);
        strcpy(p->pass,mk);
        p->sta = status;
        p->next = NULL;
    }
    return p;
}

struct node * addNode(struct node *head,char tk[20],char mk[20],int status){
if(head == NULL)
return makeNode(tk,mk,status);
struct node * cur = (struct node*)malloc(sizeof(struct node));
cur = head;
while(cur -> next != NULL) cur = cur->next;
cur -> next = makeNode(tk,mk,status);
return head;
}
void printList(struct node *head){
    struct node * cur = head;
    while(cur != NULL){
        printf ("%s %s %d \n",cur->acc,cur->pass,cur->sta);
        cur = cur -> next;
    }
}
void readFile(struct node * head){
    FILE *f;
    f = fopen("account.txt","r");
    char c;
    char tk[20],mk[20];
    int status;
    struct node * p;
    int count = 0;
    c = fgetc(f);
    while(c!= EOF){
        if(c == '\n') count ++;
        c = fgetc(f);
    }
    fclose(f);
    f = fopen("account.txt","r");
    for(int i = 0;i< count +1;i++){
        fscanf("%s,%s,%d",tk,mk,&status);
        addNode(head,tk,mk,status);
    }
    fclose(f);
}

int main(){
    struct node * head = NULL;
    readFile(head);
    printList(head);
    return 0;

}












