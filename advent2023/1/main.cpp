#include <fstream>
#include <iostream>
#include <string>

#define FALSE 0;
#define TRUE 1;

int main(int argc, char const *argv[]) {
  std::string line;
  std::ifstream file("input.txt");

  std::string myNumbers[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

  if (file.is_open()) {

    size_t sum = 0;

    while (std::getline(file, line)) {
      // std::cout << line << "\n";

      size_t i = 0;
      size_t j = line.length() - 1;

      while (i <= j) {
        char iChar = line[i];
        char jChar = line[j];

        bool iFound = FALSE;
        bool jFound = FALSE;

        if (isdigit(iChar)) {
          iFound = TRUE;
        }
        if (isdigit(jChar)) {
          jFound = TRUE;
        }

        if (iFound && jFound) {
          // logic
          sum += std::stoi(std::string() + iChar + jChar);
          break;
        }

        if (!iFound) {
          i++;
        }
        if (!jFound) {
          j--;
        }
      }
    }

    std::cout << sum;
    
    file.close();
  }
  return 0;
}
