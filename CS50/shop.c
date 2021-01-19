#include <stdio.h>
#include <cs50.h>

int main (void){
    int water_m = 5;
    int answer = get_int("수박 주문 개수: ");
    if (water_m > answer){
        printf("***** 수박 주문 *****\n");
        printf("주문건수: %i 건\n", answer);
        printf("기존 재고량: 5개\n");
        printf("남은 재고량: %i 개\n", water_m - answer);
        printf("매출액(부가세포함): %.0f 원\n", (answer*10000)+(answer*10000*0.1));
    }
}

