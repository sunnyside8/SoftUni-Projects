function solve(band,album,song){

    let secs = (album.length * band.length) * song.length / 2;
    console.log(`The plate was rotated ${Math.ceil(secs / 2.5)} times.`);

}
solve('Black Sabbath', 'Paranoid', 'War Pigs');