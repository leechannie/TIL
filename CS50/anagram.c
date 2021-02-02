#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//버블 정렬을 이용한 sort 함수 
void sort(char *arr){
    int temp;

    for (int i = 0; i < strlen(arr); i++){
        for (int j = 0; j < strlen(arr) - 1; j++) {
            if (arr[j] > arr[j + 1]){ //바로 오른쪽 수가 더 크면 swap
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp; 
            }
        }
    } 
}

// sort한 두 문자열이 같은지 확인해 True, False 출력 함수
void compare(char *compare1, char *compare2){
    int n = 0; 
    for (int i=0; i < strlen(compare1); i++){
        int temp = strcmp(compare1, compare2);
        n += temp; 
    }
    if (n == 0){ //strcmp를 통해 같은 문자열이면 0이 반환되므로 True 출력
       printf("True\n");
    }
    else{ //반대로 0이 아니면 완전히 같은 숫자가 아니므로 False 출력
       printf("False\n");
    }
}

int main (void) {
    //입력 받기 
    char s1[20], s2[20];
    printf("입력값(띄어쓰기로 구분): ");
    scanf("%s %s", s1, s2);
    
    //두 문자열을 정수가 큰 순서로 정렬할 함수 호출
    sort(s1);
    sort(s2);
    
    //두 문자열이 같나 확인해 값을 출력하는 함수 호출 
    compare(s1, s2);
}
