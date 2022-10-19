function createSortedList() {

  class SortedList {
    constructor() {
      this.list = [];
      this.size = this.list.length;
    }
    sortList() {
      this.list = this.list.sort((a, b) => a - b);
    }

    add(number) {
      this.sortList();
      this.list.push(number);
    }

    remove(index) {
      this.sortList();
      this.list.splice(index, 1);
    }

    get(index) {
      this.sortList();
      return this.list[index];
    }
  }

  return new SortedList();
}
let list = createSortedList();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));
