using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RouletteController : MonoBehaviour
{
    float rotSpeed = 0;  // 회전 속도  

    void Start()
    {
    }

    void Update()
    {
        // 마우스 왼쪽 버튼을 누르고 있는 도중의 처리   
        if(Input.GetMouseButton(0))
        {
            this.rotSpeed = 20;
        }

        // 회전 속도만큼 룰렛을 회전시킨다
        transform.Rotate(0, 0, this.rotSpeed);

        // 룰렛을 감속시킨다(추가)
        this.rotSpeed *= 0.96f;


    }
}
