package co.edu.uninorte.movilrubricaapp1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import co.edu.uninorte.movilrubricaapp1.Model.Asignatura;
import co.edu.uninorte.movilrubricaapp1.Model.Rubrica;
import co.edu.uninorte.movilrubricaapp1.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    MainActivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Asignatura.deleteAll(Asignatura.class);
        Rubrica.deleteAll(Rubrica.class);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        for (int i = 1; i < 4; i++) {
            Asignatura t = new Asignatura();
            t.setName("Curso " + i);
            t.setDescription("Breve Descripcion");
            t.Save();
            Rubrica r = new Rubrica();
            r.setName("Rubrica " + i);
            r.setDescripcion("Breve Descripcion");
            r.Save();
        }

        binding.viewpager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //  binding.CoursesList.setSelection(0);//Permite que la lista comience en una posicion espeficia


}


    public void StartNewCreationActivity(View view) {

        int page = binding.viewpager.getCurrentItem();

        if (page == 0) {
            Asignatura asignatura = new Asignatura();
            asignatura.setDescription("Breve Descripcion");
            asignatura.setName("Materia " + Asignatura.list2.size());
            asignatura.Save();

        } else {
            Rubrica rubrica = new Rubrica();
            rubrica.setDescripcion("Breve Descripcion");
            rubrica.setName("Rubrica " + Rubrica.list.size());
            rubrica.Save();
        }





    }


}
