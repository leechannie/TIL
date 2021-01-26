#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <cs50.h>

//9개의 배열로 점수와 학점 정의
const int scores[9]  = {95, 90, 85, 80, 75, 70, 65, 60, 0};
const char *grades[9] = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"}; 

int main (void){
    printf("학점 프로그램\n");
    printf("종료를 원하면 \"%i 를 입력\n", 999);

    //학점 테이블 출력을 위한 for문
    printf("[학점 테이블]\n");
    printf("점수: ");
    for (int i=0; i < 9; i++){
        printf(" %i ", scores[i]);
    }
    printf("\n학점:   ");
    for (int j=0; j < 9; j++){
        printf("%s  ", grades[j]);
    } printf("\n");
    
    //while을 무한 루프 
    while(1){
        int num = get_int("성적을 입력하세요 (0 ~ 100): ");
        if (num == 999){ //만약 999가 나오면 while문을 벗어남
            printf("학점 프로그램을 종료합니다.\n");
            break; 
        }
        else if (num <= 100 && num >= 0){ //0 ~ 100 사이면 학점 계산
            for (int k=0; k < 9; k++){
                if (num >= scores[k]){
                    printf("학점은 %s 입니다.", grades[k]);
                    break;
                }
            }
        }else { //0 ~ 100 사이가 아니면 잘 못된 입력을 알림
            printf("%i 성적을 올바르게 입력하세요. 범위는 0 ~ 100 입니다. \n", num);
        }
    }
} 