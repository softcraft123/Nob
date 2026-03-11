package com.armmc.app.ui.servers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.armmc.app.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0010\u001a\u00020\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tJ\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\nH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/armmc/app/ui/servers/ImageCropDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "sourceUri", "Landroid/net/Uri;", "sourceBitmap", "Landroid/graphics/Bitmap;", "onImageCropped", "Lkotlin/Function1;", "", "cropView", "Lcom/armmc/app/ui/servers/CropImageView;", "cancelButton", "Landroid/widget/Button;", "confirmButton", "setOnImageCroppedListener", "listener", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "decodeSampledBitmapFromUri", "uri", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "cropAndSave", "onDestroyView", "Companion", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* compiled from: ImageCropDialog.kt */
public final class ImageCropDialog extends DialogFragment {
    private static final String ARG_URI = "uri";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Button cancelButton;
    private Button confirmButton;
    private CropImageView cropView;
    private Function1<? super Bitmap, Unit> onImageCropped;
    private Bitmap sourceBitmap;
    private Uri sourceUri;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/armmc/app/ui/servers/ImageCropDialog$Companion;", "", "<init>", "()V", "ARG_URI", "", "newInstance", "Lcom/armmc/app/ui/servers/ImageCropDialog;", "uri", "Landroid/net/Uri;", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* compiled from: ImageCropDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImageCropDialog newInstance(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, ImageCropDialog.ARG_URI);
            ImageCropDialog imageCropDialog = new ImageCropDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ImageCropDialog.ARG_URI, uri);
            imageCropDialog.setArguments(bundle);
            return imageCropDialog;
        }
    }

    public final void setOnImageCroppedListener(Function1<? super Bitmap, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onImageCropped = function1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.Theme_ARMMC_Dialog_FullScreen);
        Bundle arguments = getArguments();
        this.sourceUri = arguments != null ? (Uri) arguments.getParcelable(ARG_URI) : null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.dialog_image_crop, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.cropView = (CropImageView) view.findViewById(R.id.cropView);
        this.cancelButton = (Button) view.findViewById(R.id.cancelButton);
        this.confirmButton = (Button) view.findViewById(R.id.confirmButton);
        Uri uri = this.sourceUri;
        Button button = null;
        if (uri != null) {
            try {
                Bitmap decodeSampledBitmapFromUri = decodeSampledBitmapFromUri(uri);
                this.sourceBitmap = decodeSampledBitmapFromUri;
                if (decodeSampledBitmapFromUri != null) {
                    CropImageView cropImageView = this.cropView;
                    if (cropImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cropView");
                        cropImageView = null;
                    }
                    cropImageView.setImageBitmap(decodeSampledBitmapFromUri);
                } else {
                    ImageCropDialog imageCropDialog = this;
                    Toast.makeText(getContext(), "Failed to load image", 0).show();
                    dismiss();
                }
            } catch (Exception unused) {
                Toast.makeText(getContext(), "Failed to load image", 0).show();
                dismiss();
            }
        }
        Button button2 = this.cancelButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelButton");
            button2 = null;
        }
        button2.setOnClickListener(new ImageCropDialog$$ExternalSyntheticLambda0(this));
        Button button3 = this.confirmButton;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmButton");
        } else {
            button = button3;
        }
        button.setOnClickListener(new ImageCropDialog$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(ImageCropDialog imageCropDialog, View view) {
        imageCropDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(ImageCropDialog imageCropDialog, View view) {
        imageCropDialog.cropAndSave();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.Bitmap decodeSampledBitmapFromUri(android.net.Uri r6) {
        /*
            r5 = this;
            android.content.Context r0 = r5.getContext()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3 = 1
            r2.inJustDecodeBounds = r3
            android.content.ContentResolver r3 = r0.getContentResolver()
            java.io.InputStream r3 = r3.openInputStream(r6)
            if (r3 == 0) goto L_0x002d
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = r3
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x0026 }
            android.graphics.BitmapFactory.decodeStream(r4, r1, r2)     // Catch:{ all -> 0x0026 }
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            goto L_0x002d
        L_0x0026:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0028 }
        L_0x0028:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r6)
            throw r0
        L_0x002d:
            int r3 = r2.outWidth
            if (r3 <= 0) goto L_0x005f
            int r3 = r2.outHeight
            if (r3 > 0) goto L_0x0036
            goto L_0x005f
        L_0x0036:
            r3 = 2048(0x800, float:2.87E-42)
            int r3 = r5.calculateInSampleSize(r2, r3, r3)
            r2.inSampleSize = r3
            r3 = 0
            r2.inJustDecodeBounds = r3
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.io.InputStream r6 = r0.openInputStream(r6)
            if (r6 == 0) goto L_0x005f
            java.io.Closeable r6 = (java.io.Closeable) r6
            r0 = r6
            java.io.InputStream r0 = (java.io.InputStream) r0     // Catch:{ all -> 0x0058 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0, r1, r2)     // Catch:{ all -> 0x0058 }
            kotlin.io.CloseableKt.closeFinally(r6, r1)
            return r0
        L_0x0058:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005a }
        L_0x005a:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r0)
            throw r1
        L_0x005f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.armmc.app.ui.servers.ImageCropDialog.decodeSampledBitmapFromUri(android.net.Uri):android.graphics.Bitmap");
    }

    private final int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        Pair pair = TuplesKt.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int i3 = 1;
        if (intValue <= i2 && intValue2 <= i) {
            return 1;
        }
        int i4 = intValue / 2;
        int i5 = intValue2 / 2;
        while (i4 / i3 >= i2 && i5 / i3 >= i) {
            i3 *= 2;
        }
        return i3;
    }

    private final void cropAndSave() {
        CropImageView cropImageView = this.cropView;
        if (cropImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            cropImageView = null;
        }
        Bitmap croppedBitmap = cropImageView.getCroppedBitmap();
        if (croppedBitmap != null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(croppedBitmap, 64, 64, true);
            Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
            Function1<? super Bitmap, Unit> function1 = this.onImageCropped;
            if (function1 != null) {
                function1.invoke(createScaledBitmap);
            }
            if (!Intrinsics.areEqual((Object) croppedBitmap, (Object) createScaledBitmap)) {
                croppedBitmap.recycle();
            }
            dismiss();
            return;
        }
        Toast.makeText(getContext(), "Failed to crop image", 0).show();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Bitmap bitmap = this.sourceBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.sourceBitmap = null;
    }
}
