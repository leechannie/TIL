#include <stdio.h>
#include <string.h>

int main(void) {

    //메모리 초기화: void* memset(void* source, int value, size_t n)
    int num1[5]; //4 바이트
    unsigned char nums2[5]; //unsigned: 양수값이랑 1바이트만 사용
    int i;

    memset(num1, 10, sizeof(num1)); // num1이 가리키는 메모리를 num1의 크기만큼 10 
    memset(nums2, 10, sizeof(nums2)); 
	
	for (i = 0; i < 5; i++) {
		printf("잘못된 초기화 결과: num1[%d] = %d \n", i, num1[i]); //memset 1바이트 단위로 세팅 →  제대로된 값 출력 불가능
	}
    printf("\n");
    for (i = 0; i < 5; i++) {
		printf("제대로된 초기화 결과: nums2[%d] = %d \n", i, nums2[i]);  //제대로된 값 출력 가능
	}
    printf("------------------------------------------------------\n \n");


    //메모리 복사: void* memcpy(void* destination, const void* source, size_t num)
    int source1[5] = {1, 2, 3, 4, 5};
	int destination1[3];
    int source2[3] = {11,12,13};
	int destination2[5];

    memcpy(destination1, source1, sizeof(source1)); //destination1에 source11의 메모리를 num 만큼 그대로 복사 (복사할 파일, 복사된 파일 바이트는 확인 X)
    memcpy(destination2, source2, sizeof(source2));

	for (i = 0; i < 3; i++) {
		printf("source > destination destination1[%d] = %d\n", i, destination1[i]); // 일부만 복사
	}
    printf("\n");
    for (i = 0; i < 5; i++) {
		printf("source < destination destination2[%d] = %d\n", i, destination2[i]); // 나머지는 0 처리
	}
    printf("------------------------------------------------------\n \n");


    //메모리 이동: void* memmove (void* dest, const void* src, size_t num);
    int ori[] = {21,22,23,24,25};
    int move[7];

    memmove(move, ori, sizeof(ori)); //move에 ori의 메모리를 똑같이 옮김
    //memmove(move, ori, sizeof(int) * 7); // 이것도 가능

    for (i = 0; i < 5; ++i) {
        printf("orignal: %d\n", ori[i]);
    }
    printf("\n");
    for (i = 0; i < 7; ++i) {
        printf("move: %d\n", move[i]); //옮기고 남는 메모리 공간은 0으로 채움 
    }
    printf("------------------------------------------------------\n \n");


    //메모리 비교: 	int memcmp(const void *s1, const void *s2, size_t n);
    char buf1[] = "abcde";
    char buf2[] = "edcba";

    int n = memcmp( buf1, buf2, sizeof(buf1)); //buf1의 바이트 수만큼 앞에서 부터 비교해와서 처음으로 다른 값의 크기를 비교함

    if(n < 0) { //두 메모리를 비교해 처음으로 다른 값이 buf2가 크면 0 보다 작은 정수 반환
        printf("buf1 < buf2\n"); // e가 a보다 아스키코드 값이 크므로 0보다 큰 정수 반환 
    }
    else if(n > 0) { //두 메모리를 비교해 처음으로 다른 값이 buf1이 크면 0 보다 큰 정수 반환
        printf("buf1 > buf2\n "); 
    }
    else if(n == 0) { //두 문자를 메모리를 같으면 0을 반환
        printf("buf1 == buf2\n");
    }
}
