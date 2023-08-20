//문제: 1019
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
function solution(input) {
    let N = input[0];
    const arr = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    let add = 0;
    for (let i = 1; N != 0; i *= 10) {
        let cur = N % 10;
        N = Math.floor(N / 10);
        // console.log(cur, N);
        arr[0] -= i;
        for (let j = 0; j < cur; j++) arr[j] += (N + 1) * i;
        arr[cur] += N * i + 1 + add;
        for (let j = cur + 1; j <= 9; j++) arr[j] += N * i;
        add += cur * i;
    }
    console.log(arr.join(" "));
}
