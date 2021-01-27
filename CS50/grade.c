#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <cs50.h>

int CalculateGrade(void);


int main(void) {
    CalculateGrade();
}

int CalculateGrade(void) {
    // 학점 테이블
    printf("학점 프로그램");
    printf("종료를 원하면 \"999\"를 입력\n");
    printf("[학점 테이블]\n");
    printf("점수: 95 \t90\t85\t80\t75\t70\t65\t60\t0\n");
    printf("학점: A+ \tA\tB+\tB\tC+\tC\tD+\tD\tF\n");

    //9개의 배열로 점수와 학점 정의
    const int scores[9]  = {95, 90, 85, 80, 75, 70, 65, 60, 0};
    const char *grades[9] = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"}; 

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
                    printf("학점은 %s 입니다. \n", grades[k]);
                    break;
                }
            }
        }else { //0 ~ 100 사이가 아니면 잘 못된 입력을 알림
            printf("%i 성적을 올바르게 입력하세요. 범위는 0 ~ 100 입니다. \n", num);
        }

    } return 0;
}