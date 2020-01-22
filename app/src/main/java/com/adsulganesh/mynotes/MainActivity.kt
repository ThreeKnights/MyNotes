package com.adsulganesh.mynotes

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_ticket.*
import kotlinx.android.synthetic.main.note_ticket.view.*


class MainActivity : AppCompatActivity() {

    var listOfNotes = arrayListOf<Note>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dummy data for notes
        listOfNotes.add(Note(1,"Crystal","Carriage quitting securing be appetite it declared. High eyes kept so busy feel call in. Would day nor ask walls known. But preserved advantage are but and certainty earnestly enjoyment. Passage weather as up am exposed. And natural related man subject. Eagerness get situation his was delighted."))
        listOfNotes.add(Note(2,"Duane","Whether article spirits new her covered hastily sitting her. Money witty books nor son add. Chicken age had evening believe but proceed pretend mrs. At missed advice my it no sister. Miss told ham dull knew see she spot near can. Spirit her entire her called."))
        listOfNotes.add(Note(3,"Brendan","Manor we shall merit by chief wound no or would. Oh towards between subject passage sending mention or it. Sight happy do burst fruit to woody begin at. Assurance perpetual he in oh determine as. The year paid met him does eyes same. Own marianne improved sociable not out. Thing do sight blush mr an. Celebrated am announcing delightful remarkably we in literature it solicitude. Design use say piqued any gay supply. Front sex match vexed her those great."))
        listOfNotes.add(Note(4,"Jennifer","Son agreed others exeter period myself few yet nature. Mention mr manners opinion if garrets enabled. To an occasional dissimilar impossible sentiments. Do fortune account written prepare invited no passage. Garrets use ten you the weather ferrars venture friends. Solid visit seems again you nor all."))
        listOfNotes.add(Note(5,"Calvin ","Admiration stimulated cultivated reasonable be projection possession of. Real no near room ye bred sake if some. Is arranging furnished knowledge agreeable so. Fanny as smile up small. It vulgar chatty simple months turned oh at change of. Astonished set expression solicitude way admiration."))
        listOfNotes.add(Note(6,"Dean","Son agreed others exeter period myself few yet nature. Mention mr manners opinion if garrets enabled. To an occasional dissimilar impossible sentiments. Do fortune account written prepare invited no passage. Garrets use ten you the weather ferrars venture friends. Solid visit seems again you nor all."))
        var adapter =noteAdapter(listOfNotes)
        NotesList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        val sv = menu!!.findItem(R.id.app_bar_search).actionView as SearchView
        val sm = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        sv.setSearchableInfo(sm.getSearchableInfo(componentName))
        sv.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query:String):Boolean{
                Toast.makeText(applicationContext,query,Toast.LENGTH_SHORT).show()
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    inner class noteAdapter:BaseAdapter{
        var lisOfNotes = arrayListOf<Note>()
        constructor(lisOfNotes:ArrayList<Note>){
            this.lisOfNotes = lisOfNotes
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var myView = layoutInflater.inflate(R.layout.note_ticket,null)
            var notes = lisOfNotes[position]
            myView.noteName.text = notes.noteName
            myView.noteDesc.text = notes.noteDesc
            return myView
        }

        override fun getItem(position: Int): Any {
            return lisOfNotes[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return lisOfNotes.size
        }
    }

    fun buAddNote(view: View) {
        var intent = Intent(this,com.adsulganesh.mynotes.AddNote::class.java)
        startActivity(intent)
    }
}
