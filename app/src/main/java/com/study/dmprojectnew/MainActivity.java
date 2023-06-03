package com.study.dmprojectnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout llm;
    Toolbar toolbar;
    RecyclerView recyclerView;
    DestinationAdapter destinationAdapter;
    List<Destination> destinationPlaces;
    int noOfDest = 5; // this has to be changed
    int noOfDestVia = 2;

    int node = 22; // this has to be changed
    Button btnFindPath;
    Button btnAdd;
    Button btnRemove;
    Spinner routeSpinner;
    Spinner startingPoint;

    ArrayList<Integer> alt;
    ArrayList<String> places;
    ArrayList<String> destPlaces;
    ArrayList<SpinnerLayout> routeChoice = new ArrayList<>();
    ArrayList<SpinnerLayout> startingPlaces = new ArrayList<>();
    Button btnHelp;
    public static int[] spinnerValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);


        //Finding  toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //

        places = new ArrayList<>();
        destPlaces = new ArrayList<>();
        String[] placesArray = getResources().getStringArray(R.array.places);
        String[] destPlacesArray = getResources().getStringArray(R.array.destPlaces);
        for (int i = 0; i < node; i++) {
            places.add(placesArray[i]);
            destPlaces.add(destPlacesArray[i]);
        }

        spinnerValues = new int[noOfDest + 1];

        String[] allPlacesStored = getResources().getStringArray(R.array.places);
        for (int i = 0; i < node; i++) {
            startingPlaces.add(new SpinnerLayout(R.drawable.ic_start_icon, allPlacesStored[i]));
        }
        startingPoint = findViewById(R.id.startingPoint);
        SpinnerAdapter spinnerAdapterStart = new SpinnerAdapter(MainActivity.this, startingPlaces);
        startingPoint.setAdapter(spinnerAdapterStart);
        startingPoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0) {
                    spinnerValues[0] = i - 1;
                } else {
                    spinnerValues[0] = -1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        String[] choice = getResources().getStringArray(R.array.choice);
        int map_icon[] = {R.drawable.ic_direct_route, R.drawable.ic_via_route1};
        for (int i = 0; i < 2; i++) {
            routeChoice.add(new SpinnerLayout(map_icon[i], choice[i]));
        }
        routeSpinner = findViewById(R.id.route_spinner);
        SpinnerAdapter spinnerAdapterRoute = new SpinnerAdapter(MainActivity.this, routeChoice);
        routeSpinner.setAdapter(spinnerAdapterRoute);

        destinationPlaces = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view_destination);
        destinationAdapter = new DestinationAdapter(this, destinationPlaces, destPlaces);
        recyclerView.setAdapter(destinationAdapter);

        btnFindPath = findViewById(R.id.btnPath);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);

        Destination destinationPointVia[] = new Destination[noOfDest];
        Destination[] destinationPoint = new Destination[1];
        int flag[] = new int[1];
        flag[0] = -3;
        llm = findViewById(R.id.llm);

        routeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    llm.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    btnAdd.setVisibility(View.INVISIBLE);
                    btnRemove.setVisibility(View.INVISIBLE);
                    if (flag[0] == -1) {
                        for (int j = 0; j < noOfDest; j++) {
                            destinationPlaces.remove(destinationPointVia[j]);
                        }
                    }
                    flag[0] = -2;


                    destinationPoint[0] = new Destination(getResources().getString(R.string.dest));
                    destinationPlaces.add(destinationPoint[0]);

                    destinationAdapter.notifyDataSetChanged();


                    btnFindPath.setOnClickListener(view1 -> {
                        int start = spinnerValues[0];
                        int dest[] = new int[1];
                        dest[0] = spinnerValues[1];
                        ShortestPathAlgo findPath = new ShortestPathAlgo(start, dest, (node - 1), 1);

                        //condition for no input in the spinner
                        if (!(spinnerValues[0] == -1 || spinnerValues[1] == -1)) {
                            ArrayList<Integer> journey = findPath.createPath();
                            alt = journey;

                            //condition for 2 consecutive destination same
                            if (spinnerValues[0] != spinnerValues[1]) {
                                getPath(journey);
                            } else {
                                Dialog errorSame = new Dialog(MainActivity.this);
                                errorSame.setContentView(R.layout.error_dialog_layout);
                                btnHelp = errorSame.findViewById(R.id.btnHelp);
                                Button btnOkay = errorSame.findViewById(R.id.btnOkay);
                                TextView setMessage = errorSame.findViewById(R.id.setMessage);
                                setMessage.setText(getResources().getString(R.string.errorMessageSame));
                                btnOkay.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        errorSame.dismiss();
                                    }
                                });
                                btnHelp.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent goHelp = new Intent(MainActivity.this, WantHelpActivity.class);
                                        startActivity(goHelp);
                                        errorSame.dismiss();
                                    }
                                });
                                errorSame.setCancelable(false);
                                errorSame.show();
                            }
                        } else {
                            Dialog errorNothingEntered = new Dialog(MainActivity.this);
                            errorNothingEntered.setContentView(R.layout.error_dialog_layout);
                            btnHelp = errorNothingEntered.findViewById(R.id.btnHelp);
                            Button btnOkay = errorNothingEntered.findViewById(R.id.btnOkay);
                            btnOkay.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    errorNothingEntered.dismiss();
                                }
                            });
                            btnHelp.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent goHelp = new Intent(MainActivity.this, WantHelpActivity.class);
                                    startActivity(goHelp);
                                    errorNothingEntered.dismiss();
                                }
                            });
                            errorNothingEntered.setCancelable(false);
                            errorNothingEntered.show();

                        }
                    });

                } else {
                    btnAdd.setVisibility(View.VISIBLE);
                    btnRemove.setVisibility(View.VISIBLE);
                    llm.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 700));
                    int[] check = {noOfDestVia};
                    if (flag[0] == -2) {
                        destinationPlaces.remove(destinationPoint[0]);
                    }
                    for (int j = 0; j < noOfDestVia; j++) {
                        destinationPointVia[j] = new Destination(getResources().getString(R.string.dest) + "-" + (j + 1));
                        destinationPlaces.add(destinationPointVia[j]);
                    }

                    btnAdd.setOnClickListener(view12 -> {
                        if (check[0] != noOfDest) {
                            destinationPointVia[check[0]] = new Destination(getResources().getString(R.string.dest) + "-" + (check[0] + 1));
                            destinationPlaces.add(destinationPointVia[check[0]]);
                            check[0]++;
                        } else {
                            Dialog warning = new Dialog(MainActivity.this);
                            warning.setContentView(R.layout.error_dialog_layout);
                            ImageView warningIcon = warning.findViewById(R.id.errorIcon);
                            warningIcon.setImageResource(R.drawable.baseline_warning_amber_24);
                            TextView txtTitle = warning.findViewById(R.id.errorTitle);
                            txtTitle.setText(getResources().getString(R.string.warning));
                            TextView txtMsg = warning.findViewById(R.id.setMessage);
                            txtMsg.setText(getResources().getString(R.string.warningMsg));
                            warning.setCancelable(false);
                            Button btnOkay = warning.findViewById(R.id.btnOkay);
                            btnOkay.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    warning.dismiss();
                                }
                            });
                            Button btnHelp = warning.findViewById(R.id.btnHelp);
                            btnHelp.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent goHelp = new Intent(MainActivity.this, WantHelpActivity.class);
                                    startActivity(goHelp);
                                }
                            });
                            warning.show();
                        }

                        destinationAdapter.notifyDataSetChanged();

                    });
                    btnRemove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (check[0] != noOfDestVia) {
                                destinationPlaces.remove(destinationPointVia[check[0] - 1]);
                                check[0]--;
                                destinationAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                    destinationAdapter.notifyDataSetChanged();
                    flag[0] = -1;


                    btnFindPath.setOnClickListener(view1 -> {
                        int start = spinnerValues[0];
                        int dest[] = new int[destinationPlaces.size()];
                        dest[0] = spinnerValues[1];
                        for (int j = 1; j < destinationPlaces.size() + 1; j++) {
                            dest[j - 1] = spinnerValues[j];
                        }
                        ShortestPathAlgo findPath = new ShortestPathAlgo(start, dest, (node - 1), (destinationPlaces.size()));

                        boolean checkForChoice[] = new boolean[1];
                        checkForChoice[0] = true;
                        for (int j = 0; j < destinationPlaces.size() + 1; j++) {
                            if (spinnerValues[j] == -1) {
                                checkForChoice[0] = false;
                                break;
                            }
                        }

                        if (checkForChoice[0]) {
                            ArrayList<Integer> journeyVia = findPath.createPath();
                            alt = journeyVia;

                            //check for error if two consecutive destinations are same
                            boolean checkForDifferent = true;

                            for (int j = 0; j < destinationPlaces.size(); j++) {
                                if (spinnerValues[j] == spinnerValues[j + 1]) {
                                    checkForDifferent = false;
                                    break;
                                }
                            }
                            if (checkForDifferent) {
                                getPath(journeyVia);
                            } else {
                                Dialog errorSameVia = new Dialog(MainActivity.this);
                                errorSameVia.setContentView(R.layout.error_dialog_layout);
                                btnHelp = errorSameVia.findViewById(R.id.btnHelp);
                                Button btnOkay = errorSameVia.findViewById(R.id.btnOkay);
                                TextView setMessage = errorSameVia.findViewById(R.id.setMessage);
                                setMessage.setText(getResources().getString(R.string.errorMessageSameVia));
                                btnOkay.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        errorSameVia.dismiss();
                                    }
                                });
                                btnHelp.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent goHelp = new Intent(MainActivity.this, WantHelpActivity.class);
                                        startActivity(goHelp);
                                        errorSameVia.dismiss();
                                    }
                                });
                                errorSameVia.setCancelable(false);
                                errorSameVia.show();
                            }
                        } else {
                            Dialog errorNothingEnteredVia = new Dialog(MainActivity.this);
                            errorNothingEnteredVia.setContentView(R.layout.error_dialog_layout);
                            btnHelp = errorNothingEnteredVia.findViewById(R.id.btnHelp);
                            Button btnOkay = errorNothingEnteredVia.findViewById(R.id.btnOkay);
                            btnOkay.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    errorNothingEnteredVia.dismiss();
                                }
                            });
                            btnHelp.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent goHelp = new Intent(MainActivity.this, WantHelpActivity.class);
                                    startActivity(goHelp);
                                    errorNothingEnteredVia.dismiss();
                                }
                            });
                            errorNothingEnteredVia.setCancelable(false);
                            errorNothingEnteredVia.show();

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //setting toolbar options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.help) {
            Intent goHelp = new Intent(MainActivity.this, WantHelpActivity.class);
            startActivity(goHelp);
        } else if (itemId == android.R.id.home) {
            Dialog exitDialog = new Dialog(this);
            exitDialog.setContentView(R.layout.exit_dialog);
            Button btnYes = exitDialog.findViewById(R.id.btnYes);
            Button btnCancel = exitDialog.findViewById(R.id.btnCancel);
            btnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exitDialog.dismiss();
                    finishAffinity();
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    exitDialog.dismiss();
                }
            });
            exitDialog.show();
        }
        else if (itemId==R.id.credits){
            Intent getCredit=new Intent(MainActivity.this, CredentialsActivity.class);
            startActivity(getCredit);
        }
        return super.onOptionsItemSelected(menuItem);
    }
    //

    public void getPath(ArrayList<Integer> path) {

        Intent iAns = new Intent(MainActivity.this, Answer.class);
        iAns.putExtra("start", path.get(0));
        iAns.putExtra("dest", path.get(1));
        iAns.putExtra("flag", 0);
        iAns.putIntegerArrayListExtra("answerList", path);
        startActivity(iAns);
        finish();

    }

    public void onBackPressed() {
        Dialog exitDialog = new Dialog(this);
        exitDialog.setContentView(R.layout.exit_dialog);
        Button btnYes = exitDialog.findViewById(R.id.btnYes);
        Button btnCancel = exitDialog.findViewById(R.id.btnCancel);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitDialog.dismiss();
                finishAffinity();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitDialog.dismiss();
            }
        });
        exitDialog.show();
    }
}