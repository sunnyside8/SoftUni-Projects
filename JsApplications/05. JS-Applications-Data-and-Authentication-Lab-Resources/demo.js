const data = {
  "body": "Quisquam beatae rerum repudiandae distinctio nesciunt nemo dolorem facilis aspernatur, totam, laudantium sunt amet non, itaque voluptate quae cumque tempore autem similique. Quisquam nemo cupiditate, facere obcaecati iure eveniet illo recusandae! Pariatur magnam commodi, doloremque, beatae unde facilis soluta blanditiis ex debitis quisquam, nostrum voluptates.",
  "title": "First try"
};
async function start() {
  const response = await fetch('http://localhost:3030/jsonstore/blog/posts',
    {
      method: 'post',
      headers: {
        'Content-type': 'application/json'
      },
      body: JSON.stringify(data)
    })
  const responseData = await response.json();

  console.log(responseData);
}