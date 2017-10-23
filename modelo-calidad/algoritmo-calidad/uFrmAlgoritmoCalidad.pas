unit uFrmAlgoritmoCalidad;

interface

uses
  Winapi.Windows, Winapi.Messages, System.SysUtils, System.Variants, System.Classes, Vcl.Graphics,
  Vcl.Controls, Vcl.Forms, Vcl.Dialogs, Vcl.StdCtrls,
  uModelo, uSubcaracteristica, Vcl.ExtCtrls, uTipoClasificacion;

type
  TfrmAlgoritmoCalidad = class(TForm)
    lblSeguridadAcceso: TLabel;
    lblExactitudResultados: TLabel;
    lblUtilizacionRecursos: TLabel;
    lblComportamientoTiempo: TLabel;
    lblToleranciaFallos: TLabel;
    lblRecuperacionErrores: TLabel;
    lblCapacidadAnalisis: TLabel;
    lblCapacidadCambio: TLabel;
    lblEstabilidad: TLabel;
    lblCapacidadSerEntendido: TLabel;
    lblCapacidadSerOperado: TLabel;
    lblCapacidadSerAtractivo: TLabel;
    lblAdaptabilidad: TLabel;
    lblInstalabilidad: TLabel;
    gbFuncionabilidad: TGroupBox;
    lblPromedioMinimo: TLabel;
    rbRegular1: TRadioButton;
    rbMala1: TRadioButton;
    rbBuena1: TRadioButton;
    gbEficiencia: TGroupBox;
    Panel1: TPanel;
    Panel2: TPanel;
    rbBuena2: TRadioButton;
    rbMala2: TRadioButton;
    rbRegular2: TRadioButton;
    Panel4: TPanel;
    rbBuena4: TRadioButton;
    rbMala4: TRadioButton;
    rbRegular4: TRadioButton;
    Panel3: TPanel;
    rbBuena3: TRadioButton;
    rbMala3: TRadioButton;
    rbRegular3: TRadioButton;
    gbFiabilidad: TGroupBox;
    Panel6: TPanel;
    rbBuena6: TRadioButton;
    rbMala6: TRadioButton;
    rbRegular6: TRadioButton;
    Panel5: TPanel;
    rbBuena5: TRadioButton;
    rbMala5: TRadioButton;
    rbRegular5: TRadioButton;
    gbMantenibilidad: TGroupBox;
    Panel8: TPanel;
    rbBuena8: TRadioButton;
    rbMala8: TRadioButton;
    rbRegular8: TRadioButton;
    Panel7: TPanel;
    rbBuena7: TRadioButton;
    rbMala7: TRadioButton;
    rbRegular7: TRadioButton;
    Panel9: TPanel;
    rbBuena9: TRadioButton;
    rbMala9: TRadioButton;
    rbRegular9: TRadioButton;
    gbUsabilidad: TGroupBox;
    Panel11: TPanel;
    rbBuena11: TRadioButton;
    rbMala11: TRadioButton;
    rbRegular11: TRadioButton;
    Panel10: TPanel;
    rbBuena10: TRadioButton;
    rbMala10: TRadioButton;
    rbRegular10: TRadioButton;
    Panel12: TPanel;
    rbBuena12: TRadioButton;
    rbMala12: TRadioButton;
    rbRegular12: TRadioButton;
    gbPortabilidad: TGroupBox;
    Panel14: TPanel;
    rbBuena14: TRadioButton;
    rbMala14: TRadioButton;
    rbRegular14: TRadioButton;
    Panel13: TPanel;
    rbBuena13: TRadioButton;
    rbMala13: TRadioButton;
    rbRegular13: TRadioButton;
    GroupBox1: TGroupBox;
    Label1: TLabel;
    btnInfoFuncionabilidad: TButton;
    btnInfoEficiencia: TButton;
    btnInfoFiabilidad: TButton;
    btnInfoMantenibilidad: TButton;
    btnInfoUsabilidad: TButton;
    btnInfoPortabilidad: TButton;
    lblInfo: TLabel;
    procedure FormCreate(Sender: TObject);
    procedure rbBuena3Click(Sender: TObject);
    procedure rbRegular3Click(Sender: TObject);
    procedure rbMala3Click(Sender: TObject);
    procedure rbBuena1Click(Sender: TObject);
    procedure rbRegular1Click(Sender: TObject);
    procedure rbMala1Click(Sender: TObject);
    procedure rbBuena2Click(Sender: TObject);
    procedure rbRegular2Click(Sender: TObject);
    procedure rbMala2Click(Sender: TObject);
    procedure rbBuena4Click(Sender: TObject);
    procedure rbRegular4Click(Sender: TObject);
    procedure rbMala4Click(Sender: TObject);
    procedure rbBuena5Click(Sender: TObject);
    procedure rbRegular5Click(Sender: TObject);
    procedure rbMala5Click(Sender: TObject);
    procedure rbBuena6Click(Sender: TObject);
    procedure rbRegular6Click(Sender: TObject);
    procedure rbMala6Click(Sender: TObject);
    procedure rbBuena7Click(Sender: TObject);
    procedure rbRegular7Click(Sender: TObject);
    procedure rbMala7Click(Sender: TObject);
    procedure rbBuena8Click(Sender: TObject);
    procedure rbRegular8Click(Sender: TObject);
    procedure rbMala8Click(Sender: TObject);
    procedure rbBuena9Click(Sender: TObject);
    procedure rbRegular9Click(Sender: TObject);
    procedure rbMala9Click(Sender: TObject);
    procedure rbBuena10Click(Sender: TObject);
    procedure rbRegular10Click(Sender: TObject);
    procedure rbMala10Click(Sender: TObject);
    procedure rbBuena11Click(Sender: TObject);
    procedure rbRegular11Click(Sender: TObject);
    procedure rbMala11Click(Sender: TObject);
    procedure rbBuena12Click(Sender: TObject);
    procedure rbRegular12Click(Sender: TObject);
    procedure rbMala12Click(Sender: TObject);
    procedure rbBuena13Click(Sender: TObject);
    procedure rbRegular13Click(Sender: TObject);
    procedure rbMala13Click(Sender: TObject);
    procedure rbBuena14Click(Sender: TObject);
    procedure rbRegular14Click(Sender: TObject);
    procedure rbMala14Click(Sender: TObject);
    procedure btnInfoFuncionabilidadClick(Sender: TObject);
    procedure btnInfoEficienciaClick(Sender: TObject);
    procedure btnInfoFiabilidadClick(Sender: TObject);
    procedure btnInfoMantenibilidadClick(Sender: TObject);
    procedure btnInfoUsabilidadClick(Sender: TObject);
    procedure btnInfoPortabilidadClick(Sender: TObject);
  private
    FModelo: TModelo;

    procedure InicializarModelo;
    procedure RecalcularPromedio;
    procedure InicializarRadioButton(ARadButtons: array of TRadioButton; AValue: Boolean);
    procedure SetDescripcion(ADescripcion: string);
  public

  end;

implementation


{$R *.dfm}

procedure TfrmAlgoritmoCalidad.RecalcularPromedio;
var
  LProm: Double;
begin
  LProm := FModelo.GetPromedioCalculado;
  Label1.Caption := Format('%.2f', [LProm]);
  if LProm >= 8.2 then
    Label1.Caption := Label1.Caption + ' - SATISFACTORIO'
  else
    Label1.Caption := Label1.Caption + ' - NO SATISFACTORIO';
end;

procedure TfrmAlgoritmoCalidad.SetDescripcion(ADescripcion: string);
begin
  lblInfo.Caption := ADescripcion;
  lblInfo.WordWrap := True;
end;

procedure TfrmAlgoritmoCalidad.btnInfoEficienciaClick(Sender: TObject);
begin
  SetDescripcion(
    'E F I C I E N C I A' + sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Utilización de recursos'+ sLineBreak +
    'Se evaluará la eficiencia del producto software de acuerdo al porcentaje de uso de procesador que realice.'+ sLineBreak +
    'Mala [41;100] 41% o más de uso de procesador.'+ sLineBreak +
    'Regular [11;40] 11% a 40% de uso de procesador.'+ sLineBreak +
    'Buena [0;10] 10% o menos de uso de procesador.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Comportamiento en el tiempo'+ sLineBreak +
    'Se evaluará el tiempo que está el producto software sin informarle al usuario del estado en que se encuentra la solicitud que realizó.'+ sLineBreak +
    'Mala [>=5] El producto está 5 o más segundos sin informar al usuario del estado de la solicitud.'+ sLineBreak +
    'Regular [2;4] El producto está entre 2 y 4 segundos sin informar al usuario del estado de la solicitud.'+ sLineBreak +
    'Buena [0;1] El producto está menos de 1 segundo sin informar al usuario del estado de la solicitud.');
end;

procedure TfrmAlgoritmoCalidad.btnInfoFiabilidadClick(Sender: TObject);
begin
  SetDescripcion(
    'F I A B I L I D A D'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Tolerancia a fallos'+ sLineBreak +
    'Características a medir:'+ sLineBreak +
    '• Cuando sucede un error se protegen los datos procesados.'+ sLineBreak +
    '• Se realiza un log de actividades que el sistema estaba haciendo.'+ sLineBreak +
    'Mala [0] No cumple con ninguna característica.'+ sLineBreak +
    'Regular [1] Cumple con 1 característica.'+ sLineBreak +
    'Buena [2] Cumple con 2 características.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Capacidad de recuperación de errores'+ sLineBreak +
    'Características a medir:'+ sLineBreak +
    '• El sistema reanuda las actividades si se produce una falla crítica.'+ sLineBreak +
    '• Reanuda sus actividades y vuelve al estado en que estaba.'+ sLineBreak +
    'Mala [0] No cumple con ninguna característica.'+ sLineBreak +
    'Regular [1] Cumple con 1 característica.'+ sLineBreak +
    'Buena [2] Cumple con 2 características.');
end;

procedure TfrmAlgoritmoCalidad.btnInfoFuncionabilidadClick(Sender: TObject);
begin
  SetDescripcion(
    'F U N C I O N A B I L I D A D'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'SEGURIDAD DE ACCESO'+ sLineBreak +
    'Características a medir:'+ sLineBreak +
    '• Encriptación de datos'+ sLineBreak +
    '• Inicio de sesión de usuarios'+ sLineBreak +
    'Mala [0] No cumple con ninguna característica.'+ sLineBreak +
    'Regular [1] Cumple con 1 característica.'+ sLineBreak +
    'Buena [2] Cumple con 2 características.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'EXACTITUD DE RESULTADOS'+ sLineBreak +
    'Capacidad del producto software para proporcionar los resultados con el grado necesario de precisión.'+ sLineBreak +
    'Mala [>=10-3] Los resultados tienen un error del orden de 10(-3) o superior.'+ sLineBreak +
    'Regular [10-4;10-6] Los resultados tienen un error del orden entre 10(-4) y 10(-6).'+ sLineBreak +
    'Buena [<=10-7] Los resultados tienen un error del orden de 10(-7) o inferior');
end;

procedure TfrmAlgoritmoCalidad.btnInfoMantenibilidadClick(Sender: TObject);
begin
  SetDescripcion(
    'M A N T E N I B I L I D A D'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Capacidad del código para ser analizado'+ sLineBreak +
    'Se tiene en cuenta el porcentaje de comentarios que posee el código por cada método y en general.'+ sLineBreak +
    'Mala [0;14] 14% o menos del código comentado.'+ sLineBreak +
    'Regular [15;29] Entre 15 y 29% del código comentado.'+ sLineBreak +
    'Buena [>=30] 30% o más del código comentado.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Capacidad del código para ser cambiado'+ sLineBreak +
    'Para evaluar la capacidad que tiene el código para ser cambiado se tomará en cuenta la complejidad ciclomática del método.'+ sLineBreak +
    'Mala [21] La complejidad ciclomática es mayor o igual a 21.'+ sLineBreak +
    'Regular [11;20] La complejidad ciclomática es entre 11 y 20.'+ sLineBreak +
    'Buena [1;10] La complejidad ciclomática es menor o igual a 10.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Estabilidad'+ sLineBreak +
    'Para determinar la estabilidad del software se evalúa el promedio de fallas que presenta el producto por prueba.'+ sLineBreak +
    'Mala [5] El software presenta un promedio 5 o más errores por prueba.'+ sLineBreak +
    'Regular [2;4] El software presenta un promedio entre 2 y 4 errores por prueba.'+ sLineBreak +
    'Buena [0;1] El software presenta un promedio entre 0 y 1 error por prueba.');
end;

procedure TfrmAlgoritmoCalidad.btnInfoPortabilidadClick(Sender: TObject);
begin
  SetDescripcion(
    'P O R T A B I L I D A D'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Adaptabilidad'+ sLineBreak +
    'Es la capacidad del producto software de adaptarse a diferentes sistemas operativos sin cambiar su estructura interna.'+ sLineBreak +
    'Mala [1] Compatible con 1 sistema operativo.'+ sLineBreak +
    'Regular [2] Compatible con 2 sistemas operativos.'+ sLineBreak +
    'Buena [>=3] Compatible con 3 o más sistemas operativos.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Instalabilidad'+ sLineBreak +
    'El producto software debe poder ser instalado en una cantidad mínima de pasos.'+ sLineBreak +
    'Mala [>7] El producto se instala en 7 o más pasos.'+ sLineBreak +
    'Regular [4;6] El producto se instala entre 4 y 6 pasos.'+ sLineBreak +
    'Buena [1;3] El producto se instala en 3 o menos pasos.');
end;

procedure TfrmAlgoritmoCalidad.btnInfoUsabilidadClick(Sender: TObject);
begin
  SetDescripcion(
    'U S A B I L I D A D'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Capacidad de ser entendido'+ sLineBreak +
    'Características a medir:'+ sLineBreak +
    '• Posee ayuda contextual sobre menús y botones de acción.'+ sLineBreak +
    '• Manual de usuario incorporado al sistema como un menú dedicado.'+ sLineBreak +
    'Mala [0] No cumple con ninguna característica.'+ sLineBreak +
    'Regular [1] Cumple con 1 característica.'+ sLineBreak +
    'Buena [2] Cumple con 2 características.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Capacidad para ser operado'+ sLineBreak +
    'Se evalúa qué requiere el usuario para operar correctamente el producto.'+ sLineBreak +
    'Mala [1] El usuario requiere consultar a personal especializado para operar el producto software.'+ sLineBreak +
    'Regular [2] El usuario requiere ayuda contextual y manual de uso para operar el producto software.'+ sLineBreak +
    'Buena [3] El usuario opera el producto software sin asistencia.'+ sLineBreak +
    ''+ sLineBreak +
    ''+ sLineBreak +
    'Capacidad de ser atractivo para el usuario'+ sLineBreak +
    'Es la agrupación correcta de funcionalidad del producto software en su interfaz gráfica'+ sLineBreak +
    'Mala [6] 6 o más pasos promedio sin organización de categoría.'+ sLineBreak +
    'Regular [3;5] Entre 3 y 5 pasos promedio y distribuidos en categorías.'+ sLineBreak +
    'Buena [1;2] 1 o 2 pasos promedio y distribuidos en categorías.');
end;

procedure TfrmAlgoritmoCalidad.FormCreate(Sender: TObject);
begin
  InicializarModelo;
  InicializarRadioButton([rbBuena1, rbBuena2, rbBuena3,
                          rbBuena4, rbBuena5, rbBuena6,
                          rbBuena7, rbBuena8, rbBuena9,
                          rbBuena10, rbBuena11, rbBuena12,
                          rbBuena13, rbBuena14], True);
  btnInfoFuncionabilidad.Click;
end;

procedure TfrmAlgoritmoCalidad.InicializarModelo;
begin
  FModelo := TModelo.Create;
  FModelo.AgregarAlModelo(lblSeguridadAcceso.Caption, 0, 8, 10);
  FModelo.AgregarAlModelo(lblExactitudResultados.Caption, 0, 8, 10);
  FModelo.AgregarAlModelo(lblUtilizacionRecursos.Caption, 0, 5, 8);
  FModelo.AgregarAlModelo(lblComportamientoTiempo.Caption, 0, 5, 10);
  FModelo.AgregarAlModelo(lblToleranciaFallos.Caption, 0, 5, 8);
  FModelo.AgregarAlModelo(lblRecuperacionErrores.Caption, 0, 5, 8);
  FModelo.AgregarAlModelo(lblCapacidadAnalisis.Caption, 0, 6, 8);
  FModelo.AgregarAlModelo(lblCapacidadCambio.Caption, 0, 6, 8);
  FModelo.AgregarAlModelo(lblEstabilidad.Caption, 0, 6, 9);
  FModelo.AgregarAlModelo(lblCapacidadSerEntendido.Caption, 0, 7, 8);
  FModelo.AgregarAlModelo(lblCapacidadSerOperado.Caption, 0, 7, 8);
  FModelo.AgregarAlModelo(lblCapacidadSerAtractivo.Caption, 0, 7, 8);
  FModelo.AgregarAlModelo(lblAdaptabilidad.Caption, 0, 7, 8);
  FModelo.AgregarAlModelo(lblInstalabilidad.Caption, 0, 7, 9);
end;

procedure TfrmAlgoritmoCalidad.InicializarRadioButton(
  ARadButtons: array of TRadioButton; AValue: Boolean);
var
  ARB: TRadioButton;
begin
  for ARB in ARadButtons do
  begin
    ARB.Checked := AValue;
  end;
end;

procedure TfrmAlgoritmoCalidad.rbBuena10Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerEntendido.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena11Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerOperado.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena12Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerAtractivo.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena13Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblAdaptabilidad.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena14Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblInstalabilidad.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena1Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblSeguridadAcceso.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena2Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblExactitudResultados.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena3Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblUtilizacionRecursos.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena4Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblComportamientoTiempo.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena5Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblToleranciaFallos.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena6Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblRecuperacionErrores.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena7Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadAnalisis.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena8Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadCambio.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbBuena9Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblEstabilidad.Caption).Clasificacion := tcBuena;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala10Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerEntendido.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala11Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerOperado.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala12Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerAtractivo.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala13Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblAdaptabilidad.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala14Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblInstalabilidad.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala1Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblSeguridadAcceso.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala2Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblExactitudResultados.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala3Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblUtilizacionRecursos.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala4Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblComportamientoTiempo.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala5Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblToleranciaFallos.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala6Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblRecuperacionErrores.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala7Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadAnalisis.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala8Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadCambio.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbMala9Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblEstabilidad.Caption).Clasificacion := tcMala;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular10Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerEntendido.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular11Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerOperado.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular12Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadSerAtractivo.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular13Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblAdaptabilidad.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular14Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblInstalabilidad.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular1Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblSeguridadAcceso.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular2Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblExactitudResultados.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular3Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblUtilizacionRecursos.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;



procedure TfrmAlgoritmoCalidad.rbRegular4Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblComportamientoTiempo.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular5Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblToleranciaFallos.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular6Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblRecuperacionErrores.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular7Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadAnalisis.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular8Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblCapacidadCambio.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

procedure TfrmAlgoritmoCalidad.rbRegular9Click(Sender: TObject);
begin
  FModelo.GetSubCaracteristicaByNombre(lblEstabilidad.Caption).Clasificacion := tcRegular;
  RecalcularPromedio;
end;

end.

