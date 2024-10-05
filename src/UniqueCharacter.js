function SearchingChallenge(str) {
    let k = parseInt(str.charAt(0));
    let substrings = [];
    subRec(substrings, k, str.substring(1));

    return challengeToken(
        substrings.reduce((a, b) => a.length > b.length ? a : b)
    );
}

function subRec(substrings, k, substr) {
    let set = new Set();
    for (let c of substr) {
        set.add(c);
    }
    if (set.size === k) {
        substrings.push(substr);
    }

    if (substr.length > 0) {
        substr = subLogic(substrings, k, substr);
        subRec(substrings, k, substr);
    }
}

function subLogic(substrings, k, substr) {
    let set = new Set();
    let strChar = substr.split('');
    let index = 0;

    for (let i = 0; i < substr.length; i++) {
        let current = strChar[i];
        if (set.size === k) {
            if (!set.has(current)) {
                substrings.push(substr.substring(0, i));
                return substr.substring(index);
            }
        }
        if (set.size < k) {
            if (set.size === 1) {
                index = i;
            }
            set.add(current);
        }
    }
    return "";
}

function challengeToken(result) {
    let challengeToken = "9t3mnbiyc2";

    result = result.replace(new RegExp(`[${challengeToken}]`, "gi"), ""); //this line may be wrong
    if (result.length === 0) {
        result = "EMPTY";
    }
    return result;
}

// Example usage
let input = "3aabacbebebe";
console.log(SearchingChallenge(input));
