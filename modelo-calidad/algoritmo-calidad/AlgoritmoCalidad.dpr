program AlgoritmoCalidad;

uses
  Vcl.Forms,
  uFrmAlgoritmoCalidad in 'uFrmAlgoritmoCalidad.pas' {frmAlgoritmoCalidad},
  uTipoClasificacion in 'uTipoClasificacion.pas',
  uSubCaracteristica in 'uSubCaracteristica.pas',
  uCalculo in 'uCalculo.pas',
  uModelo in 'uModelo.pas';

{$R *.res}

var
  LAlgoritmoCalidad: TfrmAlgoritmoCalidad;
begin
  Application.Initialize;
  Application.MainFormOnTaskbar := True;
  Application.CreateForm(TfrmAlgoritmoCalidad, LAlgoritmoCalidad);
  Application.Run;
end.
