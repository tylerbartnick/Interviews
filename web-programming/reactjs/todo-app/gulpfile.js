const gulp = require('gulp');

gulp.task('vendor', () => {
  gulp.src([
    'node_modules/materialize-css/dist/css/materialize.min.css',
    'node_modules/materialize-css/dist/js/materialize.min.js'
  ]).pipe(gulp.dest('public/vendor/materialize'));
})

gulp.task('default', ['vendor']);
