package com.example.namtran.nam123;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    static final LatLng position = new LatLng(14.058324,108.277199);
    View view;
    Marker marker;
    Polyline polyline,line;
    Polygon polygon,polygon1;
    Circle circle;
    LatLng[] list = {new LatLng(-37.1886, 145.708),new LatLng(-37.8361, 144.845),new LatLng(-38.4034,144.192),new LatLng(-38.7597, 143.67),new LatLng(-36.9672,141.083 )};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        // mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        PolylineOptions polylineOptions = new PolylineOptions().add(new LatLng(37.35, -122.0))
                .add(new LatLng(37.45, -122.0))  // North of the previous point, but at the same longitude
                .add(new LatLng(37.45, -122.2))  // Same latitude, and 30km to the west
                .add(new LatLng(37.35, -122.2))  // Same longitude, and 16km to the south
                /*.add(new LatLng(37.35, -122.0))*/; // Closes the polyline.
        PolygonOptions polygonOptions = new PolygonOptions().add(new LatLng(37.35, -122.0),
                new LatLng(37.45, -122.0),
                new LatLng(37.45, -122.2),
                new LatLng(37.35, -122.2))
                                                                    /*new LatLng(37.35, -122.0))*/;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.images);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.abc);
        final Bitmap bitmap3 = Bitmap.createScaledBitmap(bitmap2, 100, 100, true);
        final Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
        marker = mMap.addMarker(new MarkerOptions().position(position).alpha(0.5f).title("NamTran").snippet("Population: 4,137,400").icon(BitmapDescriptorFactory.defaultMarker()));
        // polyline = mMap.addPolyline(polylineOptions);// Khoanh vùng còn hở
        //polygon = mMap.addPolygon(polygonOptions);//Khoanh vùng đầy đủ

        polygon1 = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(0, 0), new LatLng(0, 5), new LatLng(3, 5))
                .strokeColor(Color.RED)
                .fillColor(Color.BLUE));

        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(37.4, -122.1))
                .radius(1000);
        circle = mMap.addCircle(circleOptions);

        /*circle.setRadius(200);
        circle.setCenter(new LatLng(37.4, -122.1));*/

        line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(-37.81319, 144.96298), new LatLng(-31.95285, 115.85734))
                .width(25)
                .color(Color.BLUE)
                .geodesic(true));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                view = getLayoutInflater().inflate(R.layout.layout_custommarker, null);
                TextView txttitle = (TextView) view.findViewById(R.id.txttitle);
                ImageView img = (ImageView) view.findViewById(R.id.img);

                txttitle.setText(marker.getTitle());
                img.setImageBitmap(bitmap1);
                return view;
            }
        });
        // Gắn hình cho 1 địa điểm
       /* LatLng NEWARK = new LatLng(40.714086, -74.228697);

        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(bitmap1)).anchor(0,1)
                .position(NEWARK, 8600f, 6500f);// 8.6km wide by 6.5km high
        mMap.addGroundOverlay(newarkMap);
        GroundOverlay imageOverlay = mMap.addGroundOverlay(newarkMap);
        imageOverlay.setImage(BitmapDescriptorFactory.fromBitmap(bitmap2));*/
        // Không hiểu
        LatLngBounds newarkBounds = new LatLngBounds(
                new LatLng(40.712216, -74.22655),       // South west corner
                new LatLng(40.773941, -74.12544));      // North east corner
        GroundOverlayOptions newarkMap2 = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromBitmap(bitmap2))
                .positionFromBounds(newarkBounds);
        mMap.addGroundOverlay(newarkMap2);
        //Không hiểu
        TileProvider tileProvider = new UrlTileProvider(256, 256) {
            @Override
            public URL getTileUrl(int i, int i2, int i3) {
                String s = String.format("abc.jpg",i,i2,i3);

                if (!checkTileExists(i,i2,i3)) {
                    return null;
                }

                try {
                    return new URL(s);
                } catch (MalformedURLException e) {
                    throw new AssertionError(e);
                }
            }
            private boolean checkTileExists(int x, int y, int zoom) {
                int minZoom = 12;
                int maxZoom = 16;

                if ((zoom < minZoom || zoom > maxZoom)) {
                    return false;
                }

                return true;
            }
        };
        TileOverlay tileOverlay = mMap.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));

        //Dấu + và - của zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //La bàn
        mMap.getUiSettings().setCompassEnabled(true);

        //Vị trí người dùng
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        //ko ra ko biết
        mMap.getUiSettings().setIndoorLevelPickerEnabled(true);

        //Di chuyển máy ảnh vệ tinh tới vị trí khi build
        LatLng VUNGTAU = new LatLng(10.374355,107.091279);
        LatLng MOUNTAIN_VIEW = new LatLng(10.326460, 107.084358);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(VUNGTAU,15));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10),2000,null);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(MOUNTAIN_VIEW).zoom(11)
                .bearing(90).tilt(10).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));



    }
}
