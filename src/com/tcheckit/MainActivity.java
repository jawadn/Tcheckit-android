package com.tcheckit;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.text.InputType;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import com.fortutech.tcheckit.ejb.sessions.Address;
import com.fortutech.tcheckit.ejb.sessions.ChoiceQuestion;
import com.fortutech.tcheckit.ejb.sessions.Media;
import com.fortutech.tcheckit.ejb.sessions.Mission;
import com.fortutech.tcheckit.ejb.sessions.PageElementMedia;
import com.fortutech.tcheckit.ejb.sessions.PageElementText;
import com.fortutech.tcheckit.ejb.sessions.PhotoInstruction;
import com.fortutech.tcheckit.ejb.sessions.Question;
import com.fortutech.tcheckit.ejb.sessions.QuestionInputNumber;
import com.fortutech.tcheckit.ejb.sessions.QuestionInputText;
import com.fortutech.tcheckit.ejb.sessions.QuestionMultipleChoice;
import com.fortutech.tcheckit.ejb.sessions.QuestionPhoto;
import com.fortutech.tcheckit.ejb.sessions.QuestionUniqueChoice;
import com.fortutech.tcheckit.ejb.sessions.Sign;
import com.fortutech.tcheckit.ejb.sessions.TcheckitMobileBean;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tcheckit.utils.Configuration;
import com.tcheckit.utils.GcmUtility;
import com.tcheckit.utils.NumberUtils;
import com.tcheckit.utils.UiUtils;
import com.tcheckit.vo.DataSession;
import com.tcheckit.vo.QuestionContainer;
import com.tcheckit.ws.AsyncCallWSReserver;

@TargetApi(14)
public class MainActivity extends MenuBasActivity {
	private GoogleMap map;
	int TAKE_PHOTO_CODE = 0;
	int PICK_PHOTO_CODE = 1;
	public static int count = 0;
	private ListView maListViewPerso;
	public ProgressDialog progressDialog;
	String message = "";
	private UiLifecycleHelper uiHelper;
	ImageView slideHandleImage;
	ExtendedSlidingDrawer slidingDrawer;
	String mCurrentPhotoPath;
	LocationListener locationListener = new MyLocationListener();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		uiHelper = new UiLifecycleHelper(this, callback);
		uiHelper.onCreate(savedInstanceState);
		GcmUtility gcmUtility = new GcmUtility();
		GoogleCloudMessaging gcm;
		 if (gcmUtility.checkPlayServices(this)) {
	            gcm = GoogleCloudMessaging.getInstance(this);
	            String regId = gcmUtility.getRegistrationId(getApplicationContext());
	            
	            if (regId.isEmpty()) {
	                gcmUtility.registerInBackground(getApplicationContext());
	            }
	        } else {
	            Log.i("MainActivity", "No valid Google Play Services APK found.");
	        }
		/*
		 * try { PackageInfo info =
		 * getPackageManager().getPackageInfo(this.getPackageName(),
		 * PackageManager.GET_SIGNATURES); for (Signature signature :
		 * info.signatures) { MessageDigest md =
		 * MessageDigest.getInstance("SHA"); md.update(signature.toByteArray());
		 * System.out.println("KeyHash : " + Base64.encodeToString(md.digest(),
		 * Base64.DEFAULT)); } } catch (NameNotFoundException e) { } catch
		 * (NoSuchAlgorithmException e) { }
		 */

		try {
			FragmentManager myFM = getSupportFragmentManager();
			SupportMapFragment myMAPF = (SupportMapFragment) myFM.findFragmentById(R.id.fragment1);
			map = myMAPF.getMap();
			map.setMyLocationEnabled(false); //true fait planter l'application
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

			// Getting LocationManager object from System Service
			// LOCATION_SERVICE
			//LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

			// Creating a criteria object to retrieve provider
			//Criteria criteria = new Criteria();
			
			 //criteria.setAccuracy(Criteria.ACCURACY_FINE);
			 //criteria.setPowerRequirement(Criteria.POWER_LOW);
			 
			// Getting the name of the best provider
			//String provider = locationManager.getBestProvider(criteria, false);

			// Getting Current Location
			//Location location = locationManager.getLastKnownLocation(provider);
			Location location = getLocation();
			
			if (location != null) {
				CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(13) // Sets
																																							// the
																																							// zoom
						.bearing(0) // Sets the orientation of the camera to
									// east
						.tilt(30) // Sets the tilt of the camera to 30 degrees
						.build(); // Creates a CameraPosition from the builder
				map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * LinearLayout missionLayout = (LinearLayout)
		 * findViewById(R.id.missionlayout); TextView descriptionMenu =
		 * (TextView) missionLayout.findViewById(R.id.textViewDescription);
		 * descriptionMenu.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { afficheDescription();
		 * 
		 * } }); TextView questionnaireMenu = (TextView)
		 * missionLayout.findViewById(R.id.textViewQuestionnaire);
		 * questionnaireMenu.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { afficheQuestionnaire();
		 * 
		 * } }); TextView autreMenu = (TextView)
		 * missionLayout.findViewById(R.id.textViewAutres);
		 * autreMenu.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { afficheAutres();
		 * 
		 * } });
		 */
		// Récupération de la listview créée dans le fichier main.xml
		maListViewPerso = (ListView) findViewById(R.id.listviewperso);

		// Création de la ArrayList qui nous permettra de remplire la listView
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

		// On déclare la HashMap qui contiendra les informations pour un item
		// Création d'une HashMap pour insérer les informations du premier item
		// de notre listView
		HashMap<String, String> map = new HashMap<String, String>();;
	
		// on insère un élément titre que l'on récupérera dans le textView titre
		// créé dans le fichier affichageitem.xml
		map.put("titre", "Word");
		// on insère un élément description que l'on récupérera dans le textView
		// description créé dans le fichier affichageitem.xml
		map.put("description", "Editeur de texte");
		// on insère la référence à l'image (convertit en String car normalement
		// c'est un int) que l'on récupérera dans l'imageView créé dans le
		// fichier affichageitem.xml
		map.put("img", String.valueOf(R.drawable.poi));
		// on insère le prix
		map.put("price", "1,5 €");
		// enfin on ajoute cette hashMap dans la arrayList
		// listItem.add(map);

		// On refait la manip plusieurs fois avec des données différentes pour
		// former les items de notre ListView

		// Création d'un SimpleAdapter qui se chargera de mettre les items
		// présent dans notre list (listItem) dans la vue affichageitem
		final SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.affichageitem, new String[] { "img", "titre", "description", "price",
				"distance" }, new int[] { R.id.img, R.id.titreMission, R.id.description, R.id.price, R.id.textDistance });

		// On attribut à notre listView l'adapter que l'on vient de créer
		maListViewPerso.setAdapter(mSchedule);
		/*
		 * if (DataSession.getInstance().getMissions() != null &&
		 * DataSession.getInstance().getMissions().length > 0) {
		 * afficheMissions(); } else {
		 */
		progressDialog = ProgressDialog.show(MainActivity.this, "", R.string.loading_mission_list + "...");
		AsyncCallWS task = new AsyncCallWS(this);
		task.execute();

		// }

		maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (DataSession.getInstance().getConsumer() != null) {
					// Je cache le listview
					((ListView) findViewById(R.id.listviewperso)).setVisibility(ListView.GONE);
					mSchedule.notifyDataSetChanged();

					// Je rends visible la mission layout
					LinearLayout missionLayout = (LinearLayout) findViewById(R.id.missionlayout);
					missionLayout.setVisibility(LinearLayout.VISIBLE);

					// Je m'occupe du contenumissionlayout
					LinearLayout contenumissionlayout = (LinearLayout) missionLayout.findViewById(R.id.contenumissionlayout);
					contenumissionlayout.removeAllViews();
					contenumissionlayout.removeAllViewsInLayout();
					contenumissionlayout.setScrollContainer(true);

					final Mission mi = DataSession.getInstance().getMissionPosition(position);
					Sign sign = DataSession.getInstance().getSignPosition(position);
					afficheMission(mi, sign);
					DataSession.getInstance().setMission(mi);
					DataSession.getInstance().setSign(sign);

					// ((SimpleAdapter) maListViewPerso.getAdapter())
					// .notifyDataSetChanged();

					// Presentation de la mission
					TextView presentationMission = new TextView(view.getContext());
					presentationMission.setText(mi.getOneDescription());
					presentationMission.setTextColor(Color.BLACK);
					LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
					llp.setMargins(20, 20, 20, 0);
					presentationMission.setLayoutParams(llp);

					contenumissionlayout.addView(presentationMission);

					message += mi.getOnePrice() + "€ à gagner sur la mission: " + sign.getName() + " " + sign.getAddress().getStreet() + " " + sign.getAddress().getPostalCode()
							+ " " + sign.getAddress().getCity();
					for (int i = 0; i < mi.getOnePageContentMain().getListPageElement().length; i++) {
						if (mi.getOnePageContentMain().getListPageElement()[i].getOnePageElementType().get_value_().equals("media")) {
							PageElementMedia pem = (PageElementMedia) mi.getOnePageContentMain().getListPageElement()[i];
							ImageView image = new ImageView(view.getContext());

							HashMap<String, Object> hm = new HashMap<String, Object>();
							String path = Configuration.imagePath + pem.getOneMedia().getPath();

							Log.d("Images", path);
							hm.put("img_path", path);
							hm.put("img_name", pem.getOneMedia().getName());
							hm.put("imageView", image);
							OneImageLoaderTask oneImageLoaderTask = new OneImageLoaderTask();
							oneImageLoaderTask.execute(hm);
							LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
							ll.setMargins(20, 20, 20, 0);
							image.setLayoutParams(ll);
							contenumissionlayout.addView(image);
						} else if (mi.getOnePageContentMain().getListPageElement()[i].getOnePageElementType().get_value_().equals("text")) {
							PageElementText pet = (PageElementText) mi.getOnePageContentMain().getListPageElement()[i];
							TextView text = new TextView(view.getContext());
							LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
							ll.setMargins(20, 20, 20, 0);
							text.setLayoutParams(ll);
							if (pet.getContent() != null && pet.getContent().length() > 0) {
								text.setText(pet.getContent());
								text.setTextColor(Color.BLACK);
								contenumissionlayout.addView(text);
							}
						}
					}

					Button but = new Button(view.getContext());
					but.setText(R.string.accept_mission);
					LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 60);
					// but.setHeight(15);
					but.setTextColor(Color.WHITE);
					but.setBackgroundResource(R.drawable.bg_btn_orange);
					but.setLayoutParams(ll);
					but.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// erreurReserverMission(v.getContext());
							accepteMission(v.getContext());

						}
					});
					contenumissionlayout.addView(but);

					if (checkFbInstalled()) {
						Button facebook = new Button(view.getContext());
						facebook.setText(R.string.publish_on_fb);
						LinearLayout.LayoutParams llf = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
						llf.setMargins(20, 0, 20, 60);
						// but.setHeight(15);
						facebook.setTextColor(Color.WHITE);
						facebook.setBackgroundResource(R.drawable.bg_btn_orange);
						facebook.setLayoutParams(llf);
						facebook.setOnClickListener(new OnClickListener() {

							@Override
							public void onClick(View v) {
								// erreurReserverMission(v.getContext());
								facebook();

							}
						});
						contenumissionlayout.addView(facebook);
					}

					// Description de la mission
					LinearLayout descriptionmissionlayout = (LinearLayout) missionLayout.findViewById(R.id.descriptionmissionlayout);
					descriptionmissionlayout.removeAllViews();
					descriptionmissionlayout.removeAllViewsInLayout();
					descriptionmissionlayout.setScrollContainer(true);

					TextView descriptionMission = new TextView(view.getContext());
					// descriptionMission.setText(mi.getOneDescription());
					// descriptionMission.setText("Si le produit n'est pas présent, vous pouvez valider directement la mission. Le questionnaire ne sera pas pris en compte.");
					descriptionMission.setTextColor(Color.BLACK);
					llp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
					llp.setMargins(20, 20, 20, 0);
					descriptionMission.setLayoutParams(llp);

					descriptionmissionlayout.addView(descriptionMission);

					
					// add the back button to popup description here
					Button backButton = new Button(view.getContext());
					backButton.setText(R.string.popup_desc_link);
					ll = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 60);

					backButton.setTextColor(Color.WHITE);
					backButton.setBackgroundResource(R.drawable.bg_btn_orange);
					backButton.setLayoutParams(ll);
					backButton.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View view) {
							// popup mission description here
							
							popupDescription(mi);
							
							

						}
					});
					descriptionmissionlayout.addView(backButton);
					
					for (int i = 0; i < mi.getListPhotosProducts().length; i++) {
						if (mi.getListPhotosProducts()[i] != null) {
							Media pem = mi.getListPhotosProducts()[i];

							ImageView image = new ImageView(view.getContext());

							HashMap<String, Object> hm = new HashMap<String, Object>();
							String path = Configuration.imagePath + pem.getPath();

							Log.d("Images", path);
							hm.put("img_path", path);
							hm.put("img_name", pem.getName());
							hm.put("imageView", image);
							OneImageLoaderTask oneImageLoaderTask = new OneImageLoaderTask();
							oneImageLoaderTask.execute(hm);
							ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
							ll.setMargins(20, 20, 20, 0);
							image.setLayoutParams(ll);
							descriptionmissionlayout.addView(image);
						}
					}
					Button butSuivant = new Button(view.getContext());
					butSuivant.setText(R.string.next);
					ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 60);

					butSuivant.setTextColor(Color.WHITE);
					butSuivant.setBackgroundResource(R.drawable.bg_btn_orange);
					butSuivant.setLayoutParams(ll);
					butSuivant.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// displays Questionnaire
							afficheQuestionnaire();

						}
					});
					descriptionmissionlayout.addView(butSuivant);

					// Questionnaire de la mission
					LinearLayout questionnairemissionlayout = (LinearLayout) missionLayout.findViewById(R.id.questionnairemissionlayout);
					questionnairemissionlayout.removeAllViews();
					questionnairemissionlayout.removeAllViewsInLayout();
					descriptionmissionlayout.setScrollContainer(true);
					ArrayList<QuestionContainer> listQuestionContainer = new ArrayList<QuestionContainer>();
					View v = new View(getApplicationContext());
					v.setBackgroundColor(getResources().getColor(R.color.orange));
					LinearLayout.LayoutParams lpp = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 3);
					lpp.setMargins(20, 10, 10, 0);
					v.setLayoutParams(lpp);
					questionnairemissionlayout.addView(v);
					for (int i = 0; i < mi.getListQuestions().length; i++) {
						LinearLayout.LayoutParams layoutparam = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
						layoutparam.setMargins(10, 10, 10, 0);
						if (mi.getListQuestions()[i] != null) {

							QuestionContainer qc = null;
							if (mi.getListQuestions()[i].getClass().equals(QuestionInputNumber.class)) {
								QuestionInputNumber qu = (QuestionInputNumber) mi.getListQuestions()[i];
								String s = qu.getOneTitle();
								TextView tv = new TextView(view.getContext());
								tv.setText(s);
								tv.setTextColor(Color.BLACK);
								tv.setLayoutParams(layoutparam);
								questionnairemissionlayout.addView(tv);
								EditText et = new EditText(view.getContext());
								LinearLayout.LayoutParams layoutparamtext = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
								layoutparamtext.setMargins(10, 30, 10, 0);
								et.setLayoutParams(layoutparamtext);
								et.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
								et.setGravity(Gravity.RIGHT);
								qc = new QuestionContainer(DataSession.getInstance().getConsumer().getId(), mi.getId(), qu.getId(), sign.getId(), et);
								listQuestionContainer.add(qc);
								questionnairemissionlayout.addView(et);
							} else if (mi.getListQuestions()[i].getClass().equals(QuestionInputText.class)) {
								QuestionInputText qu = (QuestionInputText) mi.getListQuestions()[i];
								String s = qu.getOneTitle();
								TextView tv = new TextView(view.getContext());
								tv.setText(s);
								tv.setTextColor(Color.BLACK);
								tv.setLayoutParams(layoutparam);
								questionnairemissionlayout.addView(tv);
								EditText et = new EditText(view.getContext());
								LinearLayout.LayoutParams layoutparamtext = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
								layoutparamtext.setMargins(10, 10, 10, 0);
								et.setLayoutParams(layoutparamtext);
								qc = new QuestionContainer(DataSession.getInstance().getConsumer().getId(), mi.getId(), qu.getId(), sign.getId(), et);

								listQuestionContainer.add(qc);
								questionnairemissionlayout.addView(et);
							} else if (mi.getListQuestions()[i].getClass().equals(QuestionMultipleChoice.class)) {
								QuestionMultipleChoice qu = (QuestionMultipleChoice) mi.getListQuestions()[i];
								String s = qu.getOneTitle();
								ChoiceQuestion[] choix = qu.getListChoice();
								TextView tv = new TextView(view.getContext());
								tv.setText(s);
								tv.setTextColor(Color.BLACK);
								tv.setLayoutParams(layoutparam);
								questionnairemissionlayout.addView(tv);
								ArrayList<CheckBox> listeChoices = new ArrayList<CheckBox>();
								for (ChoiceQuestion choice : choix) {
									CheckBox cb = new CheckBox(view.getContext());
									cb.setText(choice.getOneTitle());
									cb.setTextColor(Color.BLACK);
									cb.setId((Integer.parseInt(choice.getId().toString())));
									questionnairemissionlayout.addView(cb);

									listeChoices.add(cb);
								}
								qc = new QuestionContainer(DataSession.getInstance().getConsumer().getId(), mi.getId(), qu.getId(), sign.getId(), new CheckBox(view.getContext()));
								qc.setListeChoices(listeChoices);
								listQuestionContainer.add(qc);
							} else if (mi.getListQuestions()[i].getClass().equals(QuestionUniqueChoice.class)) {
								QuestionUniqueChoice qu = (QuestionUniqueChoice) mi.getListQuestions()[i];
								String s = qu.getOneTitle();
								ChoiceQuestion[] choix = qu.getListChoice();
								TextView tv = new TextView(view.getContext());
								tv.setText(s);
								tv.setTextColor(Color.BLACK);
								tv.setLayoutParams(layoutparam);
								questionnairemissionlayout.addView(tv);
								android.view.ViewGroup.LayoutParams lp = new LayoutParams(Gravity.RIGHT);
								RadioGroup rg = new RadioGroup(view.getContext());
								if (choix.length == 2 && ("OUI".equals(choix[0].getOneTitle()) || "Oui".equals(choix[0].getOneTitle()))) {
									rg.setOrientation(RadioGroup.HORIZONTAL);
								} else {
									rg.setOrientation(RadioGroup.VERTICAL);
								}
								rg.setLayoutParams(lp);
								int choicePosition = 0;
								for (ChoiceQuestion choice : choix) {
									RadioButton rb = new RadioButton(view.getContext());
									rb.setId(choice.getId().intValue());
									rb.setText(choice.getOneTitle());
									rb.setTextColor(Color.BLACK);
									rb.setLayoutParams(lp);
									// rb.setId(choicePosition++);
									rg.addView(rb);
								}
								questionnairemissionlayout.addView(rg);
								qc = new QuestionContainer(DataSession.getInstance().getConsumer().getId(), mi.getId(), qu.getId(), sign.getId(), rg);
								listQuestionContainer.add(qc);
							}else if (mi.getListQuestions()[i].getClass().equals(QuestionPhoto.class)) {
								final QuestionPhoto qu = (QuestionPhoto) mi.getListQuestions()[i];
								String s = qu.getOneTitle();
								TextView tv = new TextView(view.getContext());
								tv.setText(s);
								tv.setTextColor(Color.BLACK);
								tv.setLayoutParams(layoutparam);
								questionnairemissionlayout.addView(tv);
								
								Button butTakePicture = new Button(view.getContext());
								butTakePicture.setText(R.string.take_picture);
								ll = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, UiUtils.getUiDp(50, view.getContext()));
								ll.setMargins(20, 20, 20, 0);

								butTakePicture.setTextColor(Color.WHITE);
								butTakePicture.setBackgroundResource(R.drawable.bg_btn_orange);
								butTakePicture.setLayoutParams(ll);

								butTakePicture.setOnClickListener(new OnClickListener() {

									@Override
									public void onClick(View v) {

										Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
										cameraIntent.putExtra("questionId", qu.getId());
										// cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
										// outputFileUri);

										if (cameraIntent.resolveActivity(getPackageManager()) != null) {
											// Create the File where the photo should go
											File photoFile = null;
											try {
												photoFile = createImageFile();
											} catch (IOException ex) {
												// Error occurred while creating the File
												ex.printStackTrace();

											}
											// Continue only if the File was successfully
											// created
											if (photoFile != null) {
												cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
												startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
											}
										}

										// startActivityForResult(cameraIntent, 0);

									}
								});
								qc = new QuestionContainer(DataSession.getInstance().getConsumer().getId(), mi.getId(), qu.getId(), sign.getId(), butTakePicture);

								listQuestionContainer.add(qc);
								questionnairemissionlayout.addView(butTakePicture);
							} 
							Question q = mi.getListQuestions()[i];
							DataSession.getInstance().setQuestionContainer(listQuestionContainer.toArray(new QuestionContainer[listQuestionContainer.size()]));
						}
						questionnairemissionlayout.addView(getSeparateur(view.getContext()));
					}
					for (int i = 0; i < mi.getListPhotoInstruction().length; i++) {
						LinearLayout.LayoutParams layoutparam = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
						layoutparam.setMargins(10, 10, 10, 0);
						if (mi.getListPhotoInstruction()[i] != null) {
							PhotoInstruction pi = mi.getListPhotoInstruction()[i];
							String titre = pi.getOneTitle();
							TextView tv = new TextView(view.getContext());
							tv.setText(titre);
							tv.setTextColor(Color.BLACK);
							tv.setLayoutParams(layoutparam);
							questionnairemissionlayout.addView(tv);
							for (int j = 0; j < pi.getListPhotoExamples().length; j++) {
								if (pi.getListPhotoExamples()[j] != null) {
									Media pem = pi.getListPhotoExamples()[j];

									ImageView image = new ImageView(view.getContext());

									HashMap<String, Object> hm = new HashMap<String, Object>();
									String path = Configuration.imagePath + pem.getPath();

									Log.d("Images", path);
									hm.put("img_path", path);
									hm.put("img_name", pem.getName());
									hm.put("imageView", image);
									OneImageLoaderTask oneImageLoaderTask = new OneImageLoaderTask();
									oneImageLoaderTask.execute(hm);
									ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
									ll.setMargins(20, 20, 20, 0);
									image.setLayoutParams(ll);
									questionnairemissionlayout.addView(image);
								}
							}

						}
					}
					questionnairemissionlayout.addView(getSeparateur(view.getContext()));
					// Ajouter le layout pour afficher les miniatures de photos
					LinearLayout thumbnails = new LinearLayout(view.getContext());
					android.widget.LinearLayout.LayoutParams thumbnailsParams = new android.widget.LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
							android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
					thumbnails.setLayoutParams(thumbnailsParams);
					thumbnails.setOrientation(LinearLayout.HORIZONTAL);
					thumbnails.setId(R.string.thumbnail_id);
					ViewGroup.LayoutParams llp2 = new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					HorizontalScrollView photoSv = new HorizontalScrollView(view.getContext());
					photoSv.setLayoutParams(llp2);
					photoSv.addView(thumbnails);
					questionnairemissionlayout.addView(photoSv);
					// Ajouter le button pour prendre une photo
					Button butTakePicture = new Button(view.getContext());
					butTakePicture.setText(R.string.take_picture);
					ll = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 0);

					butTakePicture.setTextColor(Color.WHITE);
					butTakePicture.setBackgroundResource(R.drawable.bg_btn_orange);
					butTakePicture.setLayoutParams(ll);

					butTakePicture.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
							// cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
							// outputFileUri);

							if (cameraIntent.resolveActivity(getPackageManager()) != null) {
								// Create the File where the photo should go
								File photoFile = null;
								try {
									photoFile = createImageFile();
								} catch (IOException ex) {
									// Error occurred while creating the File
									ex.printStackTrace();

								}
								// Continue only if the File was successfully
								// created
								if (photoFile != null) {
									cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
									startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
								}
							}

							// startActivityForResult(cameraIntent, 0);

						}
					});
					questionnairemissionlayout.addView(butTakePicture);

					// Ajouter un bouton pour choisir une photo dans la
					// bibliotheque
					Button chooseTakePicture = new Button(view.getContext());
					chooseTakePicture.setText(R.string.choose_photo);
					ll = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 0);

					chooseTakePicture.setTextColor(Color.WHITE);
					chooseTakePicture.setBackgroundResource(R.drawable.bg_btn_orange);
					chooseTakePicture.setLayoutParams(ll);

					chooseTakePicture.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							// sendBroadcast(new
							// Intent(Intent.ACTION_MEDIA_MOUNTED,
							// Uri.parse("file://" +
							// Environment.getExternalStorageDirectory())));
							Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
							startActivityForResult(pickPhoto, PICK_PHOTO_CODE);

						}
					});
					questionnairemissionlayout.addView(chooseTakePicture);
					
					butSuivant = new Button(view.getContext());
					butSuivant.setText(R.string.next);
					ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 0);

					butSuivant.setTextColor(Color.WHITE);
					butSuivant.setBackgroundResource(R.drawable.bg_btn_orange);
					butSuivant.setLayoutParams(ll);
					butSuivant.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							// display others
							afficheAutres();

						}
					});
					questionnairemissionlayout.addView(butSuivant);
					butSuivant = new Button(view.getContext());
					butSuivant.setText(R.string.previous);
					ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 60);

					butSuivant.setTextColor(Color.WHITE);
					butSuivant.setBackgroundResource(R.drawable.bg_btn_orange);
					butSuivant.setLayoutParams(ll);
					butSuivant.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							//shows description
							afficheDescription();

						}
					});
					questionnairemissionlayout.addView(butSuivant);
					// Layout Autres
					LinearLayout autresmissionlayout = (LinearLayout) missionLayout.findViewById(R.id.autresmissionlayout);
					autresmissionlayout.removeAllViews();
					autresmissionlayout.removeAllViewsInLayout();
					autresmissionlayout.setScrollContainer(true);
					TextView titreAutre = new TextView(view.getContext());

					titreAutre.setTextColor(Color.BLACK);
					SpannableString spanString = new SpannableString("BRAVO, VOUS AVEZ TERMINE LA MISSION !");
					spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
					spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
					titreAutre.setGravity(Gravity.CENTER_HORIZONTAL);
					titreAutre.setText(spanString);
					LinearLayout.LayoutParams llt = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					llt.setMargins(40, 20, 20, 0);
					titreAutre.setLayoutParams(llt);
					autresmissionlayout.addView(titreAutre);

					TextView textAutre = new TextView(view.getContext());
					textAutre.setText(R.string.ans_alert);
					textAutre.setTextColor(Color.BLACK);
					textAutre.setGravity(Gravity.LEFT);
					LinearLayout.LayoutParams llt2 = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					llt2.setMargins(40, 20, 20, 0);
					textAutre.setLayoutParams(llt2);
					autresmissionlayout.addView(textAutre);

					Button butValider = new Button(view.getContext());
					butValider.setText(R.string.confirm);
					ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 20);
					// butValider.setHeight(15);
					butValider.setTextColor(Color.WHITE);
					butValider.setBackgroundResource(R.drawable.bg_btn_orange);
					butValider.setLayoutParams(ll);
					butValider.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							goValiderMission(v.getContext());

						}

					});
					autresmissionlayout.addView(butValider);

					Button butPrecedent = new Button(view.getContext());
					butPrecedent.setText(R.string.previous);
					ll = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, UiUtils.getUiDp(50, view.getContext()));
					ll.setMargins(20, 20, 20, 20);
					// butPrecedent.setHeight(15);
					butPrecedent.setTextColor(Color.WHITE);
					butPrecedent.setBackgroundResource(R.drawable.bg_btn_orange);
					butPrecedent.setLayoutParams(ll);
					butPrecedent.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {

							afficheQuestionnaire();
						}
					});
					autresmissionlayout.addView(butPrecedent);

					((RelativeLayout) findViewById(R.id.content)).invalidate();
					parent.refreshDrawableState();
					parent.invalidate();
					((SimpleAdapter) parent.getAdapter()).notifyDataSetChanged();
					view.refreshDrawableState();
					view.invalidate();
				} else {
					AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
					builder1.setTitle(R.string.login_btn);
					builder1.setMessage(R.string.login_register_msg);
					builder1.setCancelable(true);
					builder1.setPositiveButton(R.string.later, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
					builder1.setNegativeButton(R.string.sign_in, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
							goLogin();
						}
					});

					AlertDialog alert11 = builder1.create();
					alert11.show();
				}
			}

		});

		slideHandleImage = (ImageView) findViewById(R.id.handle);
		slidingDrawer = (ExtendedSlidingDrawer) findViewById(R.id.drawer);
		slidingDrawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {

			@Override
			public void onDrawerOpened() {
				slideHandleImage.setBackgroundResource(R.drawable.sliding_down);
			}
		});

		slidingDrawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {

			@Override
			public void onDrawerClosed() {
				slideHandleImage.setBackgroundResource(R.drawable.sliding_up);
			}
		});
	}

	public void accepteMission(Context context) {

		progressDialog = ProgressDialog.show(MainActivity.this, "", R.string.loading + "...");
		try {

			AsyncCallWSReserver task = new AsyncCallWSReserver(context, this);
			task.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	// display mission
	public void afficheMission(Mission m, Sign s) {
		LinearLayout mission = (LinearLayout) findViewById(R.id.missionlayout);

		((TextView) mission.findViewById(R.id.titreMission)).setText(s.getName());
		Address a = s.getAddress();
		((TextView) mission.findViewById(R.id.description)).setText(a.getStreet() + " " + a.getPostalCode() + " " + a.getCity());
		((TextView) mission.findViewById(R.id.price)).setText(NumberUtils.fmt(m.getOnePrice()) + "€");
		int distance = m.getDistance();
		if (a != null && a.getLatitude() != null && a.getLongitude() != null) {

			if (distance > 1000) {
				((TextView) mission.findViewById(R.id.textDistance)).setText((int) (distance / 1000) + " km");
			} else {
				((TextView) mission.findViewById(R.id.textDistance)).setText(distance + " m");
			}
		} else {
			((TextView) mission.findViewById(R.id.textDistance)).setText("~ m");
		}
		// LinearLayout.LayoutParams llp = new
		// LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 100);

		File cacheDirectory = getBaseContext().getCacheDir();
		String filePath = cacheDirectory.getPath() + "/tcheckit_" + m.getOneBrand().getOnePhoto().getName();
		File imgFile = new File(filePath);
		if (imgFile.exists()) {
			Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
			((ImageView) mission.findViewById(R.id.img)).setImageBitmap(myBitmap);

		} else {
			Drawable res = getResources().getDrawable(R.drawable.poi);
			((ImageView) mission.findViewById(R.id.img)).setImageDrawable(res);

		}
		// ((ImageView) mission.findViewById(R.id.img)).setLayoutParams(llp);
		ExtendedSlidingDrawer ex = ((ExtendedSlidingDrawer) findViewById(R.id.drawer));
		((RelativeLayout) ex.findViewById(R.id.content)).invalidate();
		((ListView) findViewById(R.id.listviewperso)).setVisibility(LinearLayout.GONE);
		((LinearLayout) findViewById(R.id.missionlayout)).setVisibility(LinearLayout.VISIBLE);

	}

	// display missions
	public void afficheMissions() {
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		maListViewPerso = (ListView) findViewById(R.id.listviewperso);
		maListViewPerso.invalidateViews();
		HashMap<String, String> map;
		FragmentManager myFM = getSupportFragmentManager();
		SupportMapFragment myMAPF = (SupportMapFragment) myFM.findFragmentById(R.id.fragment1);
		GoogleMap gmap = myMAPF.getMap();
		if (DataSession.getInstance().getMissions() != null && DataSession.getInstance().getMissions().length > 0) {
			for (Mission m : DataSession.getInstance().getMissions()) {
				if (m != null && m.getListSign() != null && m.getListSign().length > 0) {
					for (com.fortutech.tcheckit.ejb.sessions.Sign s : m.getListSign()) {
						map = new HashMap<String, String>();
						map.put("titre", s.getName());
						map.put("description", s.getAddress().getStreet() + " " + s.getAddress().getPostalCode() + " " + s.getAddress().getCity());
						map.put("img", String.valueOf(R.drawable.poi));
						map.put("price", NumberUtils.fmt(m.getOnePrice()) + "€");
						/*
						 * if (s.getAddress() != null &&
						 * s.getAddress().getLatitude() != null &&
						 * s.getAddress().getLongitude() != null) { Location
						 * loc1 = new Location(""); loc1.setLatitude(48.51);
						 * loc1.setLongitude(2.17); Location loc2 = new
						 * Location("");
						 * loc2.setLatitude(s.getAddress().getLatitude());
						 * loc2.setLongitude(s.getAddress().getLongitude()); int
						 * distance = (int) loc1.distanceTo(loc2); if (distance
						 * > 1000) { map.put("distance", (int)
						 * (loc1.distanceTo(loc2) / 1000) + " km"); } else {
						 * map.put("distance", loc1.distanceTo(loc2) + " m"); }
						 * } else { map.put("distance", "~ m"); }
						 */
						if (m.getDistance() > 0) {
							if (m.getDistance() > 1000) {
								map.put("distance", (int) (m.getDistance() / 1000) + " km");
							} else {
								map.put("distance", m.getDistance() + " m");
							}
						} else {
							map.put("distance", "~ m");
						}
						listItem.add(map);
						//
						ImageLoaderTask imageLoaderTask = new ImageLoaderTask();

						HashMap<String, Object> hm = new HashMap<String, Object>();
						String path = Configuration.imagePath + m.getOneBrand().getOnePhoto().getPath();
						Log.d("Images", path);
						hm.put("img_path", path);
						hm.put("img_name", m.getOneBrand().getOnePhoto().getName());
						hm.put("position", listItem.size() - 1);

						// Starting ImageLoaderTask to download and populate
						// image in the listview
						imageLoaderTask.execute(hm);

						//
						if (s.getAddress() != null && s.getAddress().getLongitude() != null && s.getAddress().getLatitude() != null) {
							LatLng coordinate = new LatLng(s.getAddress().getLatitude(), s.getAddress().getLongitude());
							try {
								Marker startPerc = gmap.addMarker(new MarkerOptions().position(coordinate).title(s.getName())
										.snippet(s.getAddress().getPostalCode() + " " + s.getAddress().getCity()).icon(BitmapDescriptorFactory.fromResource(R.drawable.poi)));
							} catch (Exception e) {
								// Exception levé dans l'émulateur
								Log.e("Error", e.getMessage());
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

		SimpleAdapter mSchedule = new SimpleAdapter(getBaseContext(), listItem, R.layout.affichageitem, new String[] { "img", "titre", "description", "price", "distance" },
				new int[] { R.id.img, R.id.titreMission, R.id.description, R.id.price, R.id.textDistance });
		// maListViewPerso.invalidateViews();
		// On attribut à notre listView l'adapter que l'on vient de créer
		mSchedule.notifyDataSetChanged();
		maListViewPerso.setAdapter(mSchedule);
		maListViewPerso.setVisibility(ListView.VISIBLE);
		LinearLayout mission = (LinearLayout) findViewById(R.id.missionlayout);
		mission.setVisibility(LinearLayout.GONE);
		((RelativeLayout) findViewById(R.id.content)).invalidate();
		// mSchedule.notifyDataSetChanged();

	}

	public void popupDescription(Mission mi){
		
		final PopupWindow popupMessage;
		Button btnClosePopup;
		TextView descView;
		
		LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View layout = inflater.inflate(R.layout.popup_desc, null);
		
		descView = (TextView) layout.findViewById(R.id.txtView);
		descView.setText(mi.getOneDescription());
		descView.setTextColor(Color.BLACK);
		
		popupMessage = new PopupWindow(layout,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
		popupMessage.showAtLocation(layout, Gravity.CENTER, 0, 0);
	
		btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
		btnClosePopup.setTextColor(Color.WHITE);
		btnClosePopup.setBackgroundResource(R.drawable.bg_btn_orange);
		
		LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, UiUtils.getUiDp(50, btnClosePopup.getContext()));
		ll.setMargins(20, 20, 20, 60);
		btnClosePopup.setLayoutParams(ll);
		btnClosePopup.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popupMessage.dismiss();

			}
		});
			
	}
	public void afficheContenu() {

		LinearLayout missionLayout = (LinearLayout) findViewById(R.id.missionlayout);

		((ScrollView) missionLayout.findViewById(R.id.scrollcontenumissionlayout)).setVisibility(ListView.VISIBLE);
		((LinearLayout) missionLayout.findViewById(R.id.contenumissionlayout)).setVisibility(ListView.VISIBLE);

		((ScrollView) missionLayout.findViewById(R.id.scrolldescriptionmissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.descriptionmissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrollquestionnairemissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.questionnairemissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrollautresmissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.autresmissionlayout)).setVisibility(ListView.GONE);

	}

	public void afficheDescription() {

		LinearLayout missionLayout = (LinearLayout) findViewById(R.id.missionlayout);

		((ScrollView) missionLayout.findViewById(R.id.scrollcontenumissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.contenumissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrolldescriptionmissionlayout)).setVisibility(ListView.VISIBLE);
		((LinearLayout) missionLayout.findViewById(R.id.descriptionmissionlayout)).setVisibility(ListView.VISIBLE);

		((ScrollView) missionLayout.findViewById(R.id.scrollquestionnairemissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.questionnairemissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrollautresmissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.autresmissionlayout)).setVisibility(ListView.GONE);

	}

	public void afficheQuestionnaire() {

		LinearLayout missionLayout = (LinearLayout) findViewById(R.id.missionlayout);

		((ScrollView) missionLayout.findViewById(R.id.scrollcontenumissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.contenumissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrolldescriptionmissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.descriptionmissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrollquestionnairemissionlayout)).setVisibility(ListView.VISIBLE);
		((LinearLayout) missionLayout.findViewById(R.id.questionnairemissionlayout)).setVisibility(ListView.VISIBLE);

		((ScrollView) missionLayout.findViewById(R.id.scrollautresmissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.autresmissionlayout)).setVisibility(ListView.GONE);

	}

	public void afficheAutres() {

		LinearLayout missionLayout = (LinearLayout) findViewById(R.id.missionlayout);

		((ScrollView) missionLayout.findViewById(R.id.scrollcontenumissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.contenumissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrolldescriptionmissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.descriptionmissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrollquestionnairemissionlayout)).setVisibility(ListView.GONE);
		((LinearLayout) missionLayout.findViewById(R.id.questionnairemissionlayout)).setVisibility(ListView.GONE);

		((ScrollView) missionLayout.findViewById(R.id.scrollautresmissionlayout)).setVisibility(ListView.VISIBLE);
		((LinearLayout) missionLayout.findViewById(R.id.autresmissionlayout)).setVisibility(ListView.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);

		startActivity(intent);
	}

	// open myaccount 
	public void openMonCompte(View view) {
		Intent intent = new Intent(this, MonCompteActivity.class);

		startActivity(intent);
	}

	// my wallet
	public void openMonPorteMonnaie(View view) {
		Intent intent = new Intent(this, MonPorteMonnaieActivity.class);

		startActivity(intent);
	}

	public void openReglages(View view) {
		Intent intent = new Intent(this, ReglagesActivity.class);

		startActivity(intent);
	}

	public void openAutres(View view) {
		Intent intent = new Intent(this, AutresActivity.class);

		startActivity(intent);
	}

	public void goMain(View view) {
		afficheContenu();
		DataSession.getInstance().setMission(null);
		DataSession.getInstance().setSign(null);
		progressDialog = ProgressDialog.show(MainActivity.this, "", R.string.loading + "...");
		DataSession.getInstance().setMission(null);
		DataSession.getInstance().setQuestionContainer(null);
		DataSession.getInstance().setSign(null);
		AsyncCallWS task = new AsyncCallWS(this);
		task.execute();

	}

	private class AsyncCallWS extends AsyncTask<String, Void, Void> {

		Context context;
		ArrayList<Mission> missions = null;

		private AsyncCallWS(Context context) {
			this.context = context.getApplicationContext();
		}

		@Override
		protected Void doInBackground(String... params) {
			Log.i("Tcheckit", "doInBackground Get la liste des missions");
			TcheckitMobileBean tb = new TcheckitMobileBean();

			try {
				LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				// Creating a criteria object to retrieve provider
				//Criteria criteria = new Criteria();
				
				  //criteria.setAccuracy(Criteria.ACCURACY_FINE);
				  //criteria.setPowerRequirement(Criteria.POWER_LOW);
				 

				// Getting the name of the best provider
				//String provider = locationManager.getBestProvider(criteria, false);

				// Getting Current Location
				//Location location = locationManager.getLastKnownLocation(provider);
				Location location = getLocation();
				
				if (DataSession.getInstance().getConsumer() != null) {
					if (location == null) {// Utilisateur non localisé
						// DataSession.getInstance().setMissions(tb.getListMissionByConsumer(DataSession.getInstance().getConsumer()));
						// Toast.makeText(getApplicationContext(),
						// "La localisation ne fonctionne pas!!!",
						// Toast.LENGTH_SHORT).show();
					} else {
						int perimetre = Integer.MAX_VALUE;
						SharedPreferences prefs = getApplicationContext().getSharedPreferences("tcheckit", 0);
						String tmp = prefs.getString("filtrePerimetreActif", "NON");
						if (tmp != null && tmp.equals("OUI")) {// Filtre actif

							if (DataSession.getInstance().getPerimetre(getApplicationContext()) != null) {
								perimetre = DataSession.getInstance().getPerimetre(getApplicationContext());
							}

							DataSession.getInstance().setMissions(
									tb.getListMissionByDistanceByConsumer(location.getLatitude(), location.getLongitude(), perimetre, DataSession.getInstance().getConsumer()
											.getId()));
						} else {
							DataSession.getInstance().setMissions(
									tb.getListMissionByDistanceByConsumer(location.getLatitude(), location.getLongitude(), perimetre, DataSession.getInstance().getConsumer()
											.getId()));
						}
						/*
						 * DataSession.getInstance() .setMissions(
						 * tb.getListMissionByConsumerByDistance(
						 * DataSession.getInstance() .getConsumer(), 48.51,
						 * 2.17, 500));
						 */
					}
				} else {// Mode démo
					DataSession.getInstance().setMissions(tb.getListMissions());
				}

				// DataSession.getInstance().setMissions(tb.getListMissions());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// textError = (TextView) findViewById(R.id.textViewError);

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// Log.i("Tcheckit", "onPostExecute");
			afficheMissions();
			progressDialog.hide();

		}

		@Override
		protected void onPreExecute() {
			// Log.i("Tcheckit", "onPreExecute");

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// Log.i("Tcheckit", "onProgressUpdate");
		}

	}

	/** AsyncTask to download and load an image in ListView */
	private class ImageLoaderTask extends AsyncTask<HashMap<String, Object>, Void, HashMap<String, Object>> {

		@Override
		protected HashMap<String, Object> doInBackground(HashMap<String, Object>... hm) {

			InputStream iStream = null;
			String imgUrl = (String) hm[0].get("img_path");
			String imgName = (String) hm[0].get("img_name");
			int position = (Integer) hm[0].get("position");

			URL url;
			try {

				// Getting Caching directory
				File cacheDirectory = getBaseContext().getCacheDir();
				String filePath = cacheDirectory.getPath() + "/tcheckit_" + imgName;

				// Temporary file to store the downloaded image
				File tmpFile = new File(filePath);
				if (!tmpFile.exists()) {
					url = new URL(imgUrl);

					// Creating an http connection to communicate with url
					HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

					// Connecting to url
					urlConnection.connect();

					// Reading data from url
					iStream = urlConnection.getInputStream();

					// The FileOutputStream to the temporary file
					FileOutputStream fOutStream = new FileOutputStream(tmpFile);

					// Creating a bitmap from the downloaded inputstream
					Bitmap b = BitmapFactory.decodeStream(iStream);
					int height = b.getHeight();
					int width = b.getWidth();
					double y = (160.0 / width) * height;
					Bitmap scaledBitmap = Bitmap.createScaledBitmap(b, 160, (int) y, true);

					// Writing the bitmap to the temporary file as png file
					scaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOutStream);

					// Flush the FileOutputStream
					fOutStream.flush();

					// Close the FileOutputStream
					fOutStream.close();

					System.gc();
				}
				// Create a hashmap object to store image path and its position
				// in the listview
				HashMap<String, Object> hmBitmap = new HashMap<String, Object>();

				// Storing the path to the temporary image file
				hmBitmap.put("flag", tmpFile.getPath());

				// Storing the position of the image in the listview
				hmBitmap.put("position", position);

				// Returning the HashMap object containing the image path and
				// position
				return hmBitmap;

			} catch (Exception e) {
				e.printStackTrace();
				Log.d("MainActivity", e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(HashMap<String, Object> result) {
			if (result != null) {
				// Getting the path to the downloaded image
				String path = (String) result.get("flag");

				// Getting the position of the downloaded image
				int position = (Integer) result.get("position");

				// Getting adapter of the listview
				SimpleAdapter adapter = (SimpleAdapter) maListViewPerso.getAdapter();

				if (position < adapter.getCount()) {
					// Getting the hashmap object at the specified position of
					// the
					// listview

					HashMap<String, Object> hm = (HashMap<String, Object>) adapter.getItem(position);

					// Overwriting the existing path in the adapter
					hm.put("img", path);

					// Noticing listview about the dataset changes
					adapter.notifyDataSetChanged();
				}
			}
		}
	}

	/** AsyncTask to download and load an image in ListView */
	private class OneImageLoaderTask extends AsyncTask<HashMap<String, Object>, Void, HashMap<String, Object>> {

		@Override
		protected HashMap<String, Object> doInBackground(HashMap<String, Object>... hm) {

			InputStream iStream = null;
			String imgUrl = (String) hm[0].get("img_path");
			String imgName = (String) hm[0].get("img_name");
			ImageView imageview = (ImageView) hm[0].get("imageView");
			Bitmap scaledBitmap = null;

			URL url;
			try {

				// Getting Caching directory
				File cacheDirectory = getBaseContext().getCacheDir();
				String filePath = cacheDirectory.getPath() + "/tcheckit_" + imgName + ".png";

				// Temporary file to store the downloaded image
				File tmpFile = new File(filePath);
				if (!tmpFile.exists()) {
					url = new URL(imgUrl);

					// Creating an http connection to communicate with url
					HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

					// Connecting to url
					urlConnection.connect();

					// Reading data from url
					iStream = urlConnection.getInputStream();

					// The FileOutputStream to the temporary file
					FileOutputStream fOutStream = new FileOutputStream(tmpFile);

					// Creating a bitmap from the downloaded inputstream
					scaledBitmap = BitmapFactory.decodeStream(iStream);

					// Writing the bitmap to the temporary file as png file
					scaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOutStream);

					// Flush the FileOutputStream
					fOutStream.flush();

					// Close the FileOutputStream
					fOutStream.close();

					System.gc();
				} else {
					scaledBitmap = BitmapFactory.decodeFile(filePath);
				}
				// Create a hashmap object to store image path and its position
				// in the listview
				HashMap<String, Object> hmBitmap = new HashMap<String, Object>();
				int height = scaledBitmap.getHeight();
				int width = scaledBitmap.getWidth();
				double y = (600.0 / width) * height;
				Bitmap scaledBitmap2 = Bitmap.createScaledBitmap(scaledBitmap, 600, (int) y, true);
				// Storing the path to the temporary image file
				hmBitmap.put("bitmap", scaledBitmap2);
				hmBitmap.put("imageView", imageview);

				// Returning the HashMap object containing the image path and
				// position
				return hmBitmap;

			} catch (Exception e) {
				e.printStackTrace();
				Log.d("MainActivity", e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(HashMap<String, Object> result) {
			if (result != null) {
				// Getting the path to the downloaded image
				Bitmap bitmap = (Bitmap) result.get("bitmap");
				ImageView imageview = (ImageView) result.get("imageView");
				imageview.setImageBitmap(bitmap);
				imageview.invalidate();

			}
		}
	}

	public View getSeparateur(Context c) {
		/*
		 * <View android:layout_width="fill_parent" android:layout_height="2dp"
		 * android:layout_marginLeft="20dp" android:layout_marginRight="20dp"
		 * android:layout_marginTop="20dp" android:background="#f7931e"
		 * android:paddingTop="20dp" />
		 */
		View v = new View(c);

		v.setBackgroundColor(getResources().getColor(R.color.orange));
		LinearLayout.LayoutParams layoutparamtext = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 3);
		layoutparamtext.setMargins(10, 10, 10, 0);
		v.setLayoutParams(layoutparamtext);

		return v;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		/*
		 * if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
		 * Bitmap photo = (Bitmap) data.getExtras().get("data"); ImageView iv =
		 * new ImageView(); imageView.setImageBitmap(photo); }
		 */
		uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
			@Override
			public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
				Log.e("Activity", String.format("Error: %s", error.toString()));
			}

			@Override
			public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
				Log.i("Activity", "Success!");
			}
		});
		switch (requestCode) {
		case 0:// Prendre une photo
			/*
			 * final String dir =
			 * Environment.getExternalStoragePublicDirectory(Environment
			 * .DIRECTORY_PICTURES) + "/Tcheckit/"; File newdir = new File(dir);
			 * newdir.mkdirs(); String timeStamp = new
			 * SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); String
			 * file = dir + timeStamp + ".jpg"; File newfile = new File(file);
			 * try { newfile.createNewFile(); } catch (IOException e) {
			 * e.printStackTrace(); } // newfile.delete();
			 * 
			 * if (data != null && data.getExtras() != null) { Bundle extras =
			 * data.getExtras(); Bitmap imageBitmap = (Bitmap)
			 * extras.get("data");
			 * 
			 * FileOutputStream out = null; try { out = new
			 * FileOutputStream(file);
			 * imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out); }
			 * catch (Exception e) { e.printStackTrace(); } finally { try {
			 * out.close(); } catch (Exception ex) { ex.printStackTrace(); } }
			 */
			if(data.getExtras().get("questionId") != null){
				Long questionId = (Long)data.getExtras().get("questionId"); 
				final BitmapFactory.Options options = new BitmapFactory.Options();
				options.inJustDecodeBounds = true;
				BitmapFactory.decodeFile(mCurrentPhotoPath, options);
				int height = options.outHeight;
				int width = options.outWidth;

				double y = (200.0 / height) * width;
				options.inSampleSize = calcSize(options, 200, y);

				options.inJustDecodeBounds = false;
				Bitmap btm = BitmapFactory.decodeFile(mCurrentPhotoPath, options);

				Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
				Uri outputFileUri = Uri.fromFile(new File(mCurrentPhotoPath));
				mediaScanIntent.setData(outputFileUri);
				sendBroadcast(mediaScanIntent);
				ImageView photo = new ImageView(getApplicationContext());
				// photo.setImageBitmap(imageBitmap);
				photo.setImageBitmap(btm);
				LinearLayout.LayoutParams photoLayout2 = new LinearLayout.LayoutParams(
						200, 200);
				photoLayout2.setMargins(20, 10, 0, 10);
				photo.setLayoutParams(photoLayout2);
				LinearLayout thumbnails = (LinearLayout) findViewById(R.string.thumbnail_id);
				thumbnails.addView(photo);
				QuestionContainer qc2 = new QuestionContainer(DataSession
						.getInstance().getConsumer().getId(), DataSession
						.getInstance().getMission().getId(), questionId, DataSession
						.getInstance().getSign().getId(), mCurrentPhotoPath);
				DataSession.getInstance().addQuestionContainer(qc2);

			} else {
				final BitmapFactory.Options options = new BitmapFactory.Options();
				options.inJustDecodeBounds = true;
				BitmapFactory.decodeFile(mCurrentPhotoPath, options);
				int height = options.outHeight;
				int width = options.outWidth;

				double y = (200.0 / height) * width;
				options.inSampleSize = calcSize(options, 200, y);

				options.inJustDecodeBounds = false;
				Bitmap btm = BitmapFactory.decodeFile(mCurrentPhotoPath,
						options);

				Intent mediaScanIntent = new Intent(
						Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
				Uri outputFileUri = Uri.fromFile(new File(mCurrentPhotoPath));
				mediaScanIntent.setData(outputFileUri);
				sendBroadcast(mediaScanIntent);
				ImageView photo = new ImageView(getApplicationContext());
				// photo.setImageBitmap(imageBitmap);
				photo.setImageBitmap(btm);
				LinearLayout.LayoutParams photoLayout2 = new LinearLayout.LayoutParams(
						200, 200);
				photoLayout2.setMargins(20, 10, 0, 10);
				photo.setLayoutParams(photoLayout2);
				LinearLayout thumbnails = (LinearLayout) findViewById(R.string.thumbnail_id);
				thumbnails.addView(photo);
				QuestionContainer qc2 = new QuestionContainer(DataSession
						.getInstance().getConsumer().getId(), DataSession
						.getInstance().getMission().getId(), null, DataSession
						.getInstance().getSign().getId(), mCurrentPhotoPath);
				DataSession.getInstance().addQuestionContainer(qc2);

			}
			// }
			break;
		case 1: // Choisir une photo
			if (resultCode == RESULT_OK) {
				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String picturePath = cursor.getString(columnIndex);
				cursor.close();

				LinearLayout.LayoutParams photoLayout = new LinearLayout.LayoutParams(200, 200);
				photoLayout.setMargins(20, 10, 0, 10);

				ImageView imageView = new ImageView(getApplicationContext());
				imageView.setLayoutParams(photoLayout);
				if (picturePath != null) {
					final BitmapFactory.Options options2 = new BitmapFactory.Options();
					options2.inJustDecodeBounds = true;
					BitmapFactory.decodeFile(picturePath, options2);
					int height2 = options2.outHeight;
					int width2 = options2.outWidth;

					double y2 = (200.0 / height2) * width2;
					options2.inSampleSize = calcSize(options2, 200, y2);

					options2.inJustDecodeBounds = false;
					Bitmap btm2 = BitmapFactory.decodeFile(picturePath, options2);

					ExifInterface exif;

					if (btm2 != null) {

						// Bitmap scaledBitmap2 = Bitmap.createScaledBitmap(btm,
						// 200, (int) y2, true);

						imageView.setImageBitmap(btm2);

						((LinearLayout) findViewById(R.string.thumbnail_id)).addView(imageView);
						QuestionContainer qc = new QuestionContainer(DataSession.getInstance().getConsumer().getId(), DataSession.getInstance().getMission().getId(), null,
								DataSession.getInstance().getSign().getId(), picturePath);

						DataSession.getInstance().addQuestionContainer(qc);
					}

				}
			}
			break;

		}
	}

	public static int calcSize(BitmapFactory.Options options, double width, double height) {
		final int uHeight = options.outHeight;
		final int uWidth = options.outWidth;
		int inSampleSize = 1;
		if (uHeight > height || uWidth > width) {
			if (uWidth > uHeight) {
				inSampleSize = Math.round((float) uHeight / (float) height);
			} else {
				inSampleSize = Math.round((float) uWidth / (float) width);
			}
		}
		return inSampleSize;
	}

	private void goValiderMission(Context context) {

		AsyncCallWSSave task = new AsyncCallWSSave(context);
		task.execute();

	}

	private class AsyncCallWSSave extends AsyncTask<String, Void, Void> {

		public ProgressDialog progressDialog;
		Context context;

		public AsyncCallWSSave(Context context) {
			this.context = context;
		}
		
		@Override
		protected Void doInBackground(String... params) {
			Log.i("Tcheckit", "doInBackground AsyncCallWSSave");
			
			saveMissionAnswers();
			return null;
			
		}
		
	/*	@Override
		protected Void doInBackground(String... params) {
			Log.i("Tcheckit", "doInBackground AsyncCallWSSave");
			TcheckitMobileBean tb = new TcheckitMobileBean();
			QuestionContainer[] QuestionContainerTableau = DataSession.getInstance().getQuestionContainer();
			LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE);
			  criteria.setPowerRequirement(Criteria.POWER_LOW);
			String provider = locationManager.getBestProvider(criteria, false);
			Location location = locationManager.getLastKnownLocation(provider);
			Location location = getLocation();
			try {
				tb.updateLocalisationConsumer(DataSession.getInstance().getConsumer().getId(), location.getLatitude(), location.getLongitude());
				for (QuestionContainer question : QuestionContainerTableau) {

					if (DataSession.getInstance().getConsumer() != null) {
						if (question.getView() == null && question.getImagePath() != null) {
							// ImageView image = (ImageView) question.getView();

							// image.setDrawingCacheEnabled(true);
							// Bitmap bitmap = ((BitmapDrawable)
							// image.getDrawable()).getBitmap();
							final BitmapFactory.Options options = new BitmapFactory.Options();
							options.inJustDecodeBounds = true;
							BitmapFactory.decodeFile(question.getImagePath(), options);
							int height2 = options.outHeight;
							int width2 = options.outWidth;
							double y2 = (800.0 / width2) * height2;
							options.inSampleSize = calcSize(options, y2, 800);

							options.inJustDecodeBounds = false;
							Bitmap btm = null;

							btm = BitmapFactory.decodeFile(question.getImagePath(), options);

							// Bitmap scaledBitmap =
							// Bitmap.createScaledBitmap(btm, 800, (int) y2,
							// true);
							// btm = null;
							ByteArrayOutputStream stream = new ByteArrayOutputStream();
							btm.compress(Bitmap.CompressFormat.JPEG, 90, stream);
							btm.recycle();
							byte[] byteArray = stream.toByteArray();
							stream = null;
							String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
							byteArray = null;
							tb.uploadImages(imageString, question.getIdMission(), question.getIdConsumer(), question.getIdSign());
							btm.recycle();
							btm = null;
							stream = null;
							byteArray = null;
							System.gc();
							// scaledBitmap = null;
						} else if (question.getView().getClass().equals(EditText.class)) {
							if (((EditText) question.getView()).getInputType() == (InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL)) {
								try {
									String leNombre = ((TextView) question.getView()).getText().toString();
									Double reponse = Double.parseDouble(leNombre);
									tb.sendResponseQuestionInputNumber(question.getIdMission(), question.getIdConsumer(), reponse, question.getIdQuestion(), question.getIdSign());
								} catch (NumberFormatException e) {
									e.printStackTrace();
								}

							} else {
								tb.sendResponseQuestionInputText(question.getIdMission(), question.getIdConsumer(), ((TextView) question.getView()).getText().toString(),
										question.getIdQuestion(), question.getIdSign());
							}
						} else if (question.getView().getClass().equals(RadioGroup.class)) {
							tb.sendResponseQuestionUniqueChoice(question.getIdMission(), question.getIdConsumer(), ((RadioGroup) question.getView()).getCheckedRadioButtonId(),
									question.getIdQuestion(), question.getIdSign());
						} else if (question.getView().getClass().equals(CheckBox.class)) {
							ArrayList<CheckBox> listeChoices = question.getListeChoices();
							String listeChequed = "";
							for (CheckBox qc : listeChoices) {
								if (qc.isChecked()) {
									listeChequed += qc.getId() + ";";
								}
							}

							tb.sendResponseQuestionMultipleChoice(question.getIdMission(), question.getIdConsumer(), listeChequed, question.getIdQuestion(), question.getIdSign()); // ((CheckBox)
																																													// question.getView()).getText().toString(),

						}
					} else {

					}

					// DataSession.getInstance().setMissions(tb.getListMissions());

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// textError = (TextView) findViewById(R.id.textViewError);

			}
			return null;
		}
		*/
		
		public void saveMissionAnswers(){
			
			TcheckitMobileBean tb = new TcheckitMobileBean();
			QuestionContainer[] QuestionContainerTableau = DataSession.getInstance().getQuestionContainer();
			
			Location location = getLocation();
			try {
				tb.updateLocalisationConsumer(DataSession.getInstance().getConsumer().getId(), location.getLatitude(), location.getLongitude());
				JSONObject jsonObject = new JSONObject();
				JSONArray jsonArray = new JSONArray();
				long missionId = 0; 
				long consumerId = DataSession.getInstance().getConsumer().getId();
				long signId = 0;
				Map<Long,List<String>> questionImageListMap = null;
				JSONObject ansJsonObj;
				
				for (QuestionContainer question : QuestionContainerTableau) {

					if (DataSession.getInstance().getConsumer() != null) {
						
						ansJsonObj = new JSONObject();
						String type = null;
						String responseString = null;
						missionId = question.getIdMission(); 
						signId = question.getIdSign();
						questionImageListMap = new HashMap<Long,List<String>>();	
						
						if (question.getView() == null && question.getImagePath() != null) {
							// ImageView image = (ImageView) question.getView();

							// image.setDrawingCacheEnabled(true);
							// Bitmap bitmap = ((BitmapDrawable)
							// image.getDrawable()).getBitmap();
							final BitmapFactory.Options options = new BitmapFactory.Options();
							options.inJustDecodeBounds = true;
							BitmapFactory.decodeFile(question.getImagePath(), options);
							int height2 = options.outHeight;
							int width2 = options.outWidth;
							double y2 = (800.0 / width2) * height2;
							options.inSampleSize = calcSize(options, y2, 800);

							options.inJustDecodeBounds = false;
							Bitmap btm = null;

							btm = BitmapFactory.decodeFile(question.getImagePath(), options);

							// Bitmap scaledBitmap =
							// Bitmap.createScaledBitmap(btm, 800, (int) y2,
							// true);
							// btm = null;
							ByteArrayOutputStream stream = new ByteArrayOutputStream();
							btm.compress(Bitmap.CompressFormat.JPEG, 90, stream);
							btm.recycle();
							byte[] byteArray = stream.toByteArray();
							stream = null;
							String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
							byteArray = null;
							tb.uploadImages(imageString, question.getIdMission(), question.getIdConsumer(), question.getIdSign());
							btm.recycle();
							btm = null;
							stream = null;
							byteArray = null;
							System.gc();
							// scaledBitmap = null;
						}else if (Long.valueOf(question.getIdQuestion()) != null && question.getImagePath() != null) {
							// ImageView image = (ImageView) question.getView();

							// image.setDrawingCacheEnabled(true);
							// Bitmap bitmap = ((BitmapDrawable)
							// image.getDrawable()).getBitmap();
							final BitmapFactory.Options options = new BitmapFactory.Options();
							options.inJustDecodeBounds = true;
							BitmapFactory.decodeFile(question.getImagePath(), options);
							int height2 = options.outHeight;
							int width2 = options.outWidth;
							double y2 = (800.0 / width2) * height2;
							options.inSampleSize = calcSize(options, y2, 800);

							options.inJustDecodeBounds = false;
							Bitmap btm = null;

							btm = BitmapFactory.decodeFile(question.getImagePath(), options);

							// Bitmap scaledBitmap =
							// Bitmap.createScaledBitmap(btm, 800, (int) y2,
							// true);
							// btm = null;
							ByteArrayOutputStream stream = new ByteArrayOutputStream();
							btm.compress(Bitmap.CompressFormat.JPEG, 90, stream);
							btm.recycle();
							byte[] byteArray = stream.toByteArray();
							stream = null;
							String imageString = Base64.encodeToString(byteArray, Base64.DEFAULT);
							byteArray = null;
							tb.uploadImages(imageString, question.getIdMission(), question.getIdConsumer(), question.getIdSign());
							
							List<String> imageList = questionImageListMap.get(question.getIdQuestion());
							if(imageList == null){
								imageList = new ArrayList<String>();
							}
							imageList.add(imageString);
							questionImageListMap.put(question.getIdQuestion(), imageList);
							btm.recycle();
							btm = null;
							stream = null;
							byteArray = null;
							System.gc();
							// scaledBitmap = null;
						} else if (question.getView().getClass().equals(EditText.class)) {
							
							if (((EditText) question.getView()).getInputType() == (InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL)) {
								try {
									String leNombre = String.valueOf(((TextView) question.getView()).getText());
									type = "number";
									responseString = "";
									if(leNombre != null && !leNombre.equals("")){
										Double reponse = Double.parseDouble(leNombre);
										responseString =  String.valueOf(reponse);
										
									}
																		
								//	tb.sendResponseQuestionInputNumber(question.getIdMission(), question.getIdConsumer(), reponse, question.getIdQuestion(), question.getIdSign());
								
								} catch (NumberFormatException e) {
									e.printStackTrace();
								}

							} else {
								
								type = "text";
								responseString = ((TextView) question.getView()).getText().toString();
								
							//	tb.sendResponseQuestionInputText(question.getIdMission(), question.getIdConsumer(), ((TextView) question.getView()).getText().toString(),
							//			question.getIdQuestion(), question.getIdSign());
								
							}
							
							ansJsonObj.put("qId", question.getIdQuestion());
							ansJsonObj.put("response", responseString);
							ansJsonObj.put("type", type);
							jsonArray.put(ansJsonObj);
							
						} else if (question.getView().getClass().equals(RadioGroup.class)) {
							
							type = "unique";
							responseString = String.valueOf(((RadioGroup) question.getView()).getCheckedRadioButtonId());
							
						/*	tb.sendResponseQuestionUniqueChoice(question.getIdMission(), question.getIdConsumer(), ((RadioGroup) question.getView()).getCheckedRadioButtonId(),
									question.getIdQuestion(), question.getIdSign());*/
							

							ansJsonObj.put("qId", question.getIdQuestion());
							ansJsonObj.put("response", responseString);
							ansJsonObj.put("type", type);
							jsonArray.put(ansJsonObj);
							
						} else if (question.getView().getClass().equals(CheckBox.class)) {
							
							ArrayList<CheckBox> listeChoices = question.getListeChoices();
							JSONArray multipleChoiceArray = new JSONArray();
							String listeChequed = "";
							
							for (CheckBox qc : listeChoices) {
								if (qc.isChecked()) {
									listeChequed += qc.getId() + ";";
									JSONObject choicejsonObj = new JSONObject();
									choicejsonObj.put("id", qc.getId());
									multipleChoiceArray.put(choicejsonObj);
								}
							}
							
							type = "multiple";
														
						//	tb.sendResponseQuestionMultipleChoice(question.getIdMission(), question.getIdConsumer(), listeChequed, question.getIdQuestion(), question.getIdSign()); // ((CheckBox)
																																													// question.getView()).getText().toString(),
							ansJsonObj.put("qId", question.getIdQuestion());
							ansJsonObj.put("response", multipleChoiceArray);
							ansJsonObj.put("type", type);
							jsonArray.put(ansJsonObj);
							
						}
					
						
					} else {

					}

					// DataSession.getInstance().setMissions(tb.getListMissions());
					
				}
				
				for(Long questionId : questionImageListMap.keySet()){
					ansJsonObj = new JSONObject();
					ansJsonObj.put("qId", questionId);
					ansJsonObj.put("type", "photo");
					JSONArray imgStringJsonArray = new JSONArray();
				    for(String questionImageString : questionImageListMap.get(questionId)){
				    	JSONObject imageJson = new JSONObject();
				    	imageJson.put("imageString", questionImageString);
				    	imgStringJsonArray.put(imageJson);
					}
				   
				    ansJsonObj.put("response", imgStringJsonArray);
				    jsonArray.put(ansJsonObj);
				}
				jsonObject.put("responses", jsonArray);
				System.out.println("----------Mission question response json-------" + jsonObject.toString());
				tb.sendCompleteMissionResponse(missionId, consumerId, signId ,jsonObject.toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// textError = (TextView) findViewById(R.id.textViewError);

			}


		}

		@Override
		protected void onPostExecute(Void result) {
			// Log.i("Tcheckit", "onPostExecute");

			progressDialog.hide();
			DataSession.getInstance().setMission(null);
			DataSession.getInstance().setSign(null);
			Intent intent = new Intent(context, MainActivity.class);
			startActivity(intent);
		}

		@Override
		protected void onPreExecute() {
			// Log.i("Tcheckit", "onPreExecute");
			progressDialog = ProgressDialog.show(context, "", R.string.sending_data + "...");

		}

		@Override
		protected void onProgressUpdate(Void... values) {
			// Log.i("Tcheckit", "onProgressUpdate");
		}

	}

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state, Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
		if (state.isOpened()) {
			// System.out.println("Logged in...");
		} else if (state.isClosed()) {
			// System.out.println("Logged out...");
		}
	}

	@Override
	protected void onDestroy() {
		uiHelper.onDestroy();
		super.onDestroy();
	}

	@Override
	protected void onResume() {
		uiHelper.onResume();
		super.onResume();

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	public void facebook() {
		if (!checkNetwork()) {
			Toast.makeText(getApplicationContext(), R.string.no_internet+" ...", Toast.LENGTH_SHORT).show();
			return;
		}
		if (!checkFbInstalled()) {
			Toast.makeText(getApplicationContext(), R.string.fb_not_installed + "..", Toast.LENGTH_SHORT).show();
			return;
		}
		Toast.makeText(getApplicationContext(), R.string.loading+"...", Toast.LENGTH_SHORT).show();
		if (FacebookDialog.canPresentShareDialog(this, FacebookDialog.ShareDialogFeature.SHARE_DIALOG)) {
			FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(this).setName("Tcheck'it").setLink("http://www.tcheckit.com").setDescription(message)
					.setPicture("http://www.tcheckit.com/images/tchek-icon-114x114.png").build();
			uiHelper.trackPendingDialogCall(shareDialog.present());
		} else {
			// System.out.println("Fail Success!");
		}
	}

	private boolean checkNetwork() {
		boolean wifiAvailable = false;
		boolean mobileAvailable = false;
		ConnectivityManager conManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo[] networkInfo = conManager.getAllNetworkInfo();
		for (NetworkInfo netInfo : networkInfo) {
			if (netInfo.getTypeName().equalsIgnoreCase("WIFI"))
				if (netInfo.isConnected())
					wifiAvailable = true;
			if (netInfo.getTypeName().equalsIgnoreCase("MOBILE"))
				if (netInfo.isConnected())
					mobileAvailable = true;
		}
		return wifiAvailable || mobileAvailable;
	}

	public Boolean checkFbInstalled() {
		PackageManager pm = getPackageManager();
		boolean flag = false;
		try {
			pm.getPackageInfo("com.facebook.katana", PackageManager.GET_ACTIVITIES);
			flag = true;
		} catch (PackageManager.NameNotFoundException e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	private File createImageFile() throws IOException {

		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = "JPEG_" + timeStamp + "_";
		//File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File storageDir = getExternalCacheDir();
		File image = File.createTempFile(imageFileName, /* prefix */
				".jpg", /* suffix */
				storageDir /* directory */
		);

		// Save a file: path for use with ACTION_VIEW intents
		// mCurrentPhotoPath = "file:" + image.getAbsolutePath();
		mCurrentPhotoPath = image.getAbsolutePath();
		return image;
	}

	private boolean isNetworkConnected() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) {
			// There are no active networks.
			return false;
		} else
			return true;
	}

	public boolean isNetworkAndLocalisationOK() {
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.NO_REQUIREMENT);
		criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);
		Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, true));
		if (location == null && locationManager.isProviderEnabled(locationManager.GPS_PROVIDER)) {
			location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
		}
		if (location == null && locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER)) {
			location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
		}

		if (!isNetworkConnected()) {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle(R.string.alert);
			String message = "Vous devez avoir un accés internet pour utiliser l'application";

			builder1.setMessage(R.string.internet_required);
			builder1.setCancelable(true);
			builder1.setPositiveButton("Close", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});

			AlertDialog alert11 = builder1.create();
			alert11.show();
			return false;
		} /*
		 * else if
		 * (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER ||
		 * LocationManager.NETWORK_PROVIDER)){ AlertDialog.Builder builder1 =
		 * new AlertDialog.Builder(this); builder1.setTitle("Alerte"); String
		 * message =
		 * "Vous devez activer la géolocalisation si vous souhaitez voir les missions à proximité."
		 * ;
		 * 
		 * builder1.setMessage(message); builder1.setCancelable(true);
		 * builder1.setPositiveButton("Close", new
		 * DialogInterface.OnClickListener() { public void
		 * onClick(DialogInterface dialog, int id) { dialog.cancel(); } });
		 * 
		 * AlertDialog alert11 = builder1.create(); alert11.show(); }
		 */
		else if (location == null) {
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle(R.string.alert);
			String message = "Nous n'arrivons pas a vous géolocaliser. Vérifiez dans vos paramètres que le GPS de votre téléphone est bien activé.";

			builder1.setMessage(R.string.gps_active_msg);
			builder1.setCancelable(true);
			builder1.setPositiveButton("Close", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});

			AlertDialog alert11 = builder1.create();
			alert11.show();
			return false;
		} else {
			return true;
		}

	}
	
	public Location getLocation() {
		Location location = null;
	    try {
	    	
	    	LocationManager locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
	        // getting GPS status
	        boolean isGPSEnabled = locationManager
	                .isProviderEnabled(LocationManager.GPS_PROVIDER);

	        // getting network status
	    	boolean isNetworkEnabled = locationManager
	                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

	        if (!isGPSEnabled && !isNetworkEnabled) {
	            // no network provider is enabled
	        } else {
	           // this.canGetLocation = true;
	            if (isNetworkEnabled) {
	                locationManager.requestLocationUpdates(
	                        LocationManager.NETWORK_PROVIDER,
	                        1000l, 100f,  this.locationListener);
	                Log.d("Network", "Network Enabled");
	                if (locationManager != null) {
	                    location = locationManager
	                            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	                   
	                }
	            }
	            // if GPS Enabled get lat/long using GPS Services
	            if (isGPSEnabled) {
	                if (location == null) {
	                    locationManager.requestLocationUpdates(
	                            LocationManager.GPS_PROVIDER,
	                            1000l, 100f, this.locationListener);
	                    Log.d("GPS", "GPS Enabled");
	                    if (locationManager != null) {
	                        location = locationManager
	                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
	                        
	                    }
	                }
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return location;
	}


private final class MyLocationListener implements LocationListener {

    @Override
    public void onLocationChanged(Location locFromGps) {
        System.out.print("Ma localisation a changé:" + locFromGps.getLatitude() + " - " + locFromGps.getLongitude());
    }

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

    
}
}

