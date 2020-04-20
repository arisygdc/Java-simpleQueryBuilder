<h1>A SIMPLE QUERY BUILDER JUST FOR LEARNING<h1>
  <h5>You can contribute to help me, to complete this source code<h5>
<h2>HOW TO USE<h2>
<h5>
  <p>
  db.insert("buku").field(data[0]).value(data[1]).println();<br>
    Generate : <br>
  INSERT INTO buku (judul,pengarang) VALUES ('No Mans Sky','gedece')</p>
<hr>
<p>
  db.select("buku").field("pengarang,judul").where("id",1).println();<br>
    Generate : <br>
  SELECT pengarang,judul FROM buku WHERE id = 1 <br>
</p>
<hr>
<p>
  db.update("buku").set(dataUpdate).where("id", 1).println();<br>
    Generate : <br>
  UPDATE buku SET judul = 'Guuuede',pengarang = 'wewe' WHERE id = 1 <br>
</p>
<hr>
<p>
  db.delete("buku").where("id",1).println();<br>
    Generate : <br>
  DELETE FROM buku WHERE id = 1
</p>
</h5>
