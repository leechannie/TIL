var arrNumber = new Array(); //배열선언
var arrNumber = new Array("a","b","c","d");
var arrNumber = [8,7,3,5]; 

function sort(arrNumber){
    if(arrNumber.length < 2) {return arrNumber}
    else {var pivot = Math.floor(arrNumber.length / 2);
            var left = arrNumber.slice(0,pivot);
            var right = arrNumber.slice(pivot,arrNumber.length);
            return merge_sort(sort(left), sort(right));
    }
}

function merge_sort(left, right){
    var result = new Array();//배열선언
    while(left.length && right.length){
        if (left[0] < right[0]){
            result.push(left.shift()); //shift = 첫 요소를 제거하고, 제거된 요소 반환 
        }
        else if (left[0] >= right[0]){                        
            result.push(right.shift()); 
        } 
    }
    while (left.length) result.push(left.shift());
    while (right.length) result.push(right.shift());
    return result;
};

console.log(sort(arrNumber));