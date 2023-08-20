//문제: 2018
const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

solution(input);
// for (let i = 1; i < 20; i++) {
//     solution([i]);
// }
function solution(input) {
    let n = +input[0];
    let startIndex = 0;
    let endIndex = 0;
    let sum = 1;
    let cnt = 0;
    // const arr = Array.from({ length: n }, (v, i) => i + 1);

    while (startIndex !== n - 1) {
        if (sum < n) {
            endIndex++;
            sum += endIndex + 1;
        } else if (sum > n) {
            sum -= startIndex;
            startIndex++;
        } else {
            cnt++;
            endIndex++;
            sum += endIndex + 1;
        }
    }
    console.log(cnt + 1);
    // 시작점은 투 포인터 둘다 1 sum도 1 cnt 도 1
    // sum < n endIndex++;
    // sum > n startIndex++;
    // sum이 n 보다 같으면 cnt++ endIndex++
}
