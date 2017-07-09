package com.tenondelabs.hack2017.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.tenondelabs.hack2017.R;
import com.tenondelabs.hack2017.ui.base.BaseActivity;

import io.realm.Realm;
import retrofit2.Call;

/**
 * @author TenondeLabs
 * @version 1.0
 * Copyright 2017 TenondeLabs Inc. All rights reserved
 */
public class StartActivity extends BaseActivity {

    private static final String TAG = StartActivity.class.getSimpleName();

//    private static boolean sSyncEmpresa         = false;
//    private static boolean sSyncEmpresaImage    = false;
//    private static boolean sSyncEventoImage     = false;
//    private static boolean sSyncPromocionImage  = false;
//    private static boolean sSyncEmpresaCiudad   = false;
//    private static boolean sSyncCiudad          = false;
//    private static boolean sSyncCategoria       = false;
//    private static boolean sSyncSubcategoria    = false;
//    private static boolean sSyncEvento          = false;
//    private static boolean sSyncPromo           = false;
//    private static boolean sIsConnection        = false;
//
//    private Realm realm;
//    private AkiBuscaApiClient client;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        
        setupProgress();
//        setupRealm();
//        setupService();
//        setupApiService();
//        initData();
    }

//    private void setupService() {
//        Intent intent = new Intent(ReminderService.ACTION_NOTIFY_EVENT, null, getBaseContext(), ReminderService.class);
//        intent.putExtra(ReminderService.EXTRA_EVENT_END, 300000L);
//        intent.putExtra(ReminderService.EXTRA_EVENT_ALARM_OFFSET, 20L);
//        intent.putExtra(ReminderService.EXTRA_EVENT_ID, Util.EXTRA_EVENT_ID);
//        intent.putExtra(ReminderService.EXTRA_EVENT_TITLE, Util.EXTRA_EVENT_TITLE);
//
//        getBaseContext().startService(intent);
//    }

    private void setupProgress() {
        progressBar = (ProgressBar) findViewById(R.id.progress_indicator_start);
    }

//    private void setupRealm() {
//        realm = Realm.getDefaultInstance();
//    }
//
//    private void setupApiService() {
//        client = new AkiBuscaApiClient();
//    }
//
//    private void startPercentMockThread() {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000); //1Seg
//                    if (sIsConnection && !sSyncEmpresa && !sSyncEmpresaImage && !sSyncCategoria &&
//                        !sSyncSubcategoria && !sSyncEvento && !sSyncPromo && !sSyncEmpresaCiudad
//                            && sSyncEventoImage && sSyncPromocionImage) {
//                        while (!sSyncCiudad ) {
//                            Thread.sleep(50);
//                        }
//                    } else {
//                        for (int i = 0; i <= 50; i++) {
//                            Thread.sleep(50);
//                        }
//                    }
//
//                    Thread.sleep(1000); //1Seg
//
//                    Util.sendBroadcast(getApplicationContext());
//                    openMainActivity();
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        new Thread(runnable).start();
//    }

    private void openMainActivity() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
//        intent.putExtra(Util.IS_OFFLINE, !sIsConnection);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
//                | Intent.FLAG_ACTIVITY_NEW_TASK
//                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent, ActivityAnimation.SLIDE_LEFT);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        realm.close();
    }

    //Fixme Implement Repository Patterns
//    private void initData() {
//        Handler h = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                startPercentMockThread();
//                if (msg.what == 1) {
//                    sIsConnection = true;
//                    getEmpresas();
//                    getEmpresaAtachments();
//                    getEventoAtachments();
//                    getPromocionAtachments();
//                    getCiudades();
//                    getCategorias();
//                    getSubcategorias();
//                    getEventos();
//                    getPromos();
//                    getEmpresaCiudades();
//                } else {
//                    sIsConnection = false;
//                }
//            }
//        };
//        Util.isNetworkAvailable(h,10000,this);
//    }

//    private void getEmpresas() {
//        Callback<List<Empresa>> listener = new Callback<List<Empresa>>() {
//            @Override
//            public void success(List<Empresa> empresaList) {
//                Log.d(TAG, "Empresas: " + empresaList.size());
//                saveEmpresasStorage(empresaList);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Empresas: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Empresas: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getEmpresas().enqueue(listener);
//    }

//    private void getEmpresaCiudades() {
//        Callback<List<EmpresaCiudad>> listener = new Callback<List<EmpresaCiudad>>() {
//            @Override
//            public void success(List<EmpresaCiudad> list) {
//                Log.d(TAG, "Empresa Ciudades: " + list.size());
//                saveEmpresaCiudadStorage(list);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Empresa Ciudades: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Empresa Ciudades: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getEmpresaCiudades().enqueue(listener);
//    }

//    private void getCategorias() {
//        Callback<List<Categoria>> listener = new Callback<List<Categoria>>() {
//            @Override
//            public void success(List<Categoria> categoriaList) {
//                Log.d(TAG, "Categorias: " + categoriaList.size());
//                saveCategoriasStorage(categoriaList);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Categorias: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Empresas: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getCategorias().enqueue(listener);
//    }
//
//    private void getSubcategorias() {
//        Callback<List<Subcategoria>> listener = new Callback<List<Subcategoria>>() {
//            @Override
//            public void success(List<Subcategoria> subcategoriaList) {
//                Log.d(TAG, "Subcategoria: " + subcategoriaList.size());
//                saveSubcategoriasStorage(subcategoriaList);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Subcategorias: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Subcategoria: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getSubcategorias().enqueue(listener);
//    }
//
//    private void getCiudades() {
//        Callback<List<Ciudad>> listener = new Callback<List<Ciudad>>() {
//            @Override
//            public void success(List<Ciudad> ciudadList) {
//                Log.d(TAG, "Ciudades: " + ciudadList.size());
//                saveCiudadesStorage(ciudadList);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Ciudades: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Empresas: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getCiudades().enqueue(listener);
//    }
//
//    private void getEventos() {
//        Callback<List<Evento>> listener = new Callback<List<Evento>>() {
//            @Override
//            public void success(List<Evento> eventoListList) {
//                Log.d(TAG, "Eventos: " + eventoListList.size());
//                saveEventosStorage(eventoListList);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Eventos: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Eventos: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getEventos().enqueue(listener);
//    }
//
//    private void getPromos() {
//        Callback<List<Promocion>> listener = new Callback<List<Promocion>>() {
//            @Override
//            public void success(List<Promocion> promocionList) {
//                Log.d(TAG, "Promociones: " + promocionList.size());
//                savePromosStorage(promocionList);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Promociones: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Promociones: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getPromociones().enqueue(listener);
//    }
//
//    private void getEventoAtachments() {
//        Callback<List<EventoImage>> listener = new Callback<List<EventoImage>>() {
//            @Override
//            public void success(List<EventoImage> atachments) {
//                Log.d(TAG, "Event Atachments: " + atachments.size());
//                saveEventoImagesStorage(atachments);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Atachments: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Atachments: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getEventoImages().enqueue(listener);
//    }
//
//    private void getPromocionAtachments() {
//        Callback<List<PromocionImage>> listener = new Callback<List<PromocionImage>>() {
//            @Override
//            public void success(List<PromocionImage> atachments) {
//                Log.d(TAG, "Promocion Atachments: " + atachments.size());
//                savePromocionImagesStorage(atachments);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Atachments: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Atachments: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getPromocionImages().enqueue(listener);
//    }
//
//    private void getEmpresaAtachments() {
//        Callback<List<EmpresaImage>> listener = new Callback<List<EmpresaImage>>() {
//            @Override
//            public void success(List<EmpresaImage> atachments) {
//                Log.d(TAG, "Atachments: " + atachments.size());
//                saveEmpresaImagesStorage(atachments);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//                Log.d(TAG, "Error Atachments: " + t.getLocalizedMessage());
//            }
//
//            @Override
//            public void networkFailure(Throwable error) {
//                super.networkFailure(error);
//                Log.d(TAG, "Error Atachments: " + error.getLocalizedMessage());
//            }
//        };
//
//        client.getService().getEmpresaImages().enqueue(listener);
//    }
//
//    private void saveEmpresasStorage(final List<Empresa> empresas) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                //eliminar todas las empresas
//                realm.delete(Empresa.class);
//                realm.insert(empresas);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncEmpresa = true;
//                Log.d(TAG, "onSuccess EMP");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError EMP: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void saveEmpresaCiudadStorage(final List<EmpresaCiudad> empresaCiudades) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                //eliminar todas las empresas
//                realm.delete(EmpresaCiudad.class);
//                realm.insert(empresaCiudades);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncEmpresa = true;
//                Log.d(TAG, "onSuccess EMP CIU");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError EMP CIU: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void saveEmpresaImagesStorage(final List<EmpresaImage> empresaImages) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                //eliminar todas las empresas Imagenes
//                realm.delete(EmpresaImage.class);
//                realm.insert(empresaImages);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncEmpresaImage = true;
//                Log.d(TAG, "onSuccess EMP IMG");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError EMP IMG: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void saveEventoImagesStorage(final List<EventoImage> eventoImages) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                //eliminar todas las Imagenes de eventos
//                realm.delete(EventoImage.class);
//                realm.insert(eventoImages);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncEventoImage = true;
//                Log.d(TAG, "onSuccess EVENT IMG");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError EVENT IMG: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void savePromocionImagesStorage(final List<PromocionImage> promocionImages) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                //eliminar todas las Imagenes de promociones
//                realm.delete(PromocionImage.class);
//                realm.insert(promocionImages);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncPromocionImage = true;
//                Log.d(TAG, "onSuccess PROMO IMG");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError PROMO IMG: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void saveCategoriasStorage(final List<Categoria> categorias) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.delete(Categoria.class);
//                realm.insert(categorias);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncCategoria = true;
//                Log.d(TAG, "onSuccess CAT");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError CAT: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void saveSubcategoriasStorage(final List<Subcategoria> subcategorias) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.delete(Subcategoria.class);
//                realm.insert(subcategorias);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncSubcategoria = true;
//                Log.d(TAG, "onSuccess SUB");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError SUB: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void saveCiudadesStorage(final List<Ciudad> ciudades) {
//
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                realm.delete(Ciudad.class);
//                realm.insert(ciudades);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncCiudad = true;
//                Log.d(TAG, "onSuccess CIU");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError CIU: " + error.getLocalizedMessage() );
//            }
//        });
//    }
//
//    private void saveEventosStorage(final List<Evento> eventos) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                Evento evento;
//                for (int i = 0; i<eventos.size(); i++){
//                    evento = realm.where(Evento.class).equalTo("id", eventos.get(i).getId()).findFirst();
//                    eventos.get(i).setFavorito((evento==null)?false:evento.getFavorito());
//                }
//                realm.delete(Evento.class);
//                realm.insert(eventos);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncEvento = true;
//                Log.d(TAG, "onSuccess EVENTOS");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError EVENTOS: " + error.getLocalizedMessage());
//            }
//        });
//    }
//
//    private void savePromosStorage(final List<Promocion> promos) {
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                Promocion promo;
//                for (int i = 0; i<promos.size(); i++){
//                    promo = realm.where(Promocion.class).equalTo("id", promos.get(i).getId()).findFirst();
//                    promos.get(i).setFavorito((promo==null)?false:promo.getFavorito());
//                }
//                realm.delete(Promocion.class);
//                realm.insert(promos);
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success
//                sSyncPromo = true;
//                Log.d(TAG, "onSuccess PROMO");
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError PROMO: " + error.getLocalizedMessage());
//            }
//        });
//    }

}