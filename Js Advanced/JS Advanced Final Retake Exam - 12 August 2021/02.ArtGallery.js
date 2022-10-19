class ArtGallery {

  constructor(creator) {
    this.creator = creator;
    this.possibleArticles = { "picture": 200, "photo": 50, "item": 250 };
    this.listOfArticles = []
    this.guests = []
  }

  addArticle(articleModel, articleName, quantity) {
    let artickleType = articleModel.toLowerCase();

    if (!this.possibleArticles[artickleType]) {
      throw new Error("This article model is not included in this gallery!");
    }

    let totalquantity = quantity;
    let artickle = this.listOfArticles.find(x => x.articleName == articleName);
    if (artickle !== undefined && artickle.articleModel == articleModel) {
      totalquantity = Number(artickle.quantity) + quantity;
      artickle.quantity = totalquantity;
    } else {
      this.listOfArticles.push({ articleModel: articleModel.toLowerCase(), articleName, quantity });
    }

    return `Successfully added article ${articleName} with a new quantity- ${totalquantity}.`;
  }

  inviteGuest(guestName, personality) {
    if (this.guests.some(x => x.guestName == guestName)) {
      throw new Error(`${guestName} has already been invited.`);
    }

    let points = 0;
    if (personality === 'Vip') {
      points = 500;
    } else if (personality === 'Middle') {
      points = 250
    } else {
      points = 50
    }

    this.guests.push({ guestName, points, purchaseArticle: 0 });

    return `You have successfully invited ${guestName}!`;
  }

  buyArticle(articleModel, articleName, guestName) {
    let artickle = this.listOfArticles.find(x => x.articleName == articleName);
    if (artickle === undefined || artickle.articleModel !== articleModel) {
      throw new Error("This article is not found.");
    }

    if (artickle.quantity == 0) {
      return `The ${articleName} is not available.`;
    }

    if (!this.guests.some(x => x.guestName == guestName)) {
      return "This guest is not invited.";
    }

    let guest = this.guests.find(x => x.guestName == guestName);

    let pointsNeeded = this.possibleArticles[artickle.articleModel];
    if (guest.points < pointsNeeded) {
      return "You need to more points to purchase the article."
    }

    guest.points = Number(guest.points) - pointsNeeded;
    guest.purchaseArticle = Number(guest.purchaseArticle) + 1;
    artickle.quantity = Number(artickle.quantity) - 1;

    return `${guestName} successfully purchased the article worth ${pointsNeeded} points.`;
  }

  showGalleryInfo(criteria) {
    let list = [];
    if (criteria === 'article') {
      list.push("Articles information:");
      this.listOfArticles.forEach(x => list.push(`${x.articleModel} - ${x.articleName} - ${x.quantity}`))
    } else {
      list.push("Guests information:");
      this.guests.forEach(x => list.push(`${x.guestName} - ${x.purchaseArticle}`))
    }

    return list.join('\n');
  }
}

const artGallery = new ArtGallery('Curtis Mayfield');

artGallery.addArticle('picture', 'Mona Liza', 3);

artGallery.addArticle('Item', 'Ancient vase', 2);

artGallery.addArticle('picture', 'Mona Liza', 1);

artGallery.inviteGuest('John', 'Vip');

artGallery.inviteGuest('Peter', 'Middle');
artGallery.buyArticle('picture', 'Mona Liza', 'John');

artGallery.buyArticle('item', 'Ancient vase', 'Peter');

console.log(artGallery.showGalleryInfo('article'));

console.log(artGallery.showGalleryInfo('guest')); 