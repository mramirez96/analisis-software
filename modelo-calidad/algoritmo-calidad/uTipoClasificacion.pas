unit uTipoClasificacion;

interface

type
  TTipoClasificacion = (tcMala, tcRegular, tcBuena);

  TTipoClasificacionHelper = record helper for TTipoClasificacion
  public
    function ToString: string;
    function FromString(AString: string): TTipoClasificacion;
  end;

implementation

uses
  SysUtils;

const
  _MALA = 'Mala';
  _REGULAR = 'Regular';
  _BUENA = 'Buena';

{ TTipoClasificacionHelper }

function TTipoClasificacionHelper.FromString(
  AString: string): TTipoClasificacion;
begin
  if AString = _MALA then
    Result := tcMala
  else if AString = _REGULAR then
    Result := tcRegular
  else if AString = _BUENA then
    Result := tcBuena
  else
    raise Exception.Create('Tipo de clasificación no implementado.');
end;

function TTipoClasificacionHelper.ToString: string;
begin
  case Self of
    tcMala: Result := _MALA;
    tcRegular: Result := _REGULAR;
    tcBuena: Result := _BUENA;
  end;
end;

end.
