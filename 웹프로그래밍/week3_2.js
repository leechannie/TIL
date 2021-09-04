// const path = require('path');

// const string = __filename;

// console.log('path.sep', path.sep);
// console.log('path.delimiter', path.delimiter);
// console.log('----------------------------');
// console.log('path.dirname(): ', path.dirname(string));
// console.log('path.extname(): ', path.extname(string));
// console.log('path.basename(): ', path.basename(string));
// console.log('paht.basename - extname', path.basename(string, path.extname(string)));
// console.log('----------------------------');
// console.log('path.parse(): ', path.parse(string));
// console.log('path.format(): ',path.format({
//     dir: 'C:\\users\\zerocho',
//     name: 'path',
//     ext: '.js',
// }));
// console.log('path.normalize(): ', path.normalize('C:\\users\\\zerocho\\\path.js'));
// console.log('----------------------------');
// console.log('path.isAbsolute(C:\\): ', path.isAbsolute('C:\\'));
// console.log('path.isAbsolute(./home): ', path.isAbsolute('./home'));
// console.log('----------------------------');
// console.log('path.relative(): ', path.relative('C:\\users\\zerocho\\path.js', 'C:\\'));
// console.log('paht.join(): ', path.join(__dirname,'..','..','/users','.','/zerocho'));
// console.log('paht.resolve(): ', path.resolve(__dirname,'..','..','/users','.','/zerocho'));

const url = require('url');

const {URL} = url;
const myURL = new URL('https://www.aladin.co.kr/search/wsearchresult.aspx?SearchTarget=All&SearchWord=%EB%85%B8&x=0&y=0');
console.log('new URL: ', myURL);
console.log('url.format(): ', url.format(myURL));
console.log('----------------------------');
const parseUrl = url.parse('https://www.aladin.co.kr/search/wsearchresult.aspx?SearchTarget=All&SearchWord=%EB%85%B8&x=0&y=0');
console.log('url.format(): ', parseUrl);
console.log('url.format(): ', url.format(parseUrl));